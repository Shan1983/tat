<?php
class USER_DB_CONFIG
{
  private $db;
  private $url;
  private $reset_url;
  private $email_subject;

  function __construct( $DB_con ) {
    $this->db = $DB_con;
    $this->url = '127.0.0.1/';
    $this->reset_url = 'reset.php';
    $this->email_subject = 'TAT Password Reset Request';
  }

  /*
   * User login
   * 
   */
  public function tat_login( $uemail, $upass ) {

    try {
      $stmt = $this->db->prepare( "SELECT * FROM tat_user WHERE Email=:uemail LIMIT 1" );
      $stmt->execute( array( ':uemail'=>$uemail ) );
      $userRow = $stmt->fetch( PDO::FETCH_ASSOC );

      if ( $stmt->rowCount() > 0 ) :

        // Brute force attack variables and values
        $login_limit = 3;
        $lockout_time = 600; // 60 seconds x number of minutes

        // Check current login attempts by user
        $failed_count = $userRow['Failed_Count'];
        $failed_first_time = $userRow['Failed_First_Time'];
        // Check if user is locked out
        if ( ( $failed_count >= $login_limit ) && ( time() - $failed_first_time < $lockout_time ) ) :
          // Set session variable with attempt to count to query for error message in login-authenticate.php
          $_SESSION['lockout_check'] = $userRow['Failed_Count'];
          return false;

        // Check if user and password match
        elseif ( password_verify( $upass, $userRow['Password'] ) ) :

          // Set user role as session variable to query different views
          $_SESSION['users_type'] = $userRow['Access_Level']; 
          // Set users_id as a session variable, we can use it for the change log
          $_SESSION['users_session'] = $userRow['Id'];
          // Set last active time
          $_SESSION['last_active'] = time();
          // Set login time
          $_SESSION['login_time'] = time();
          // Reset failed count and failed first time
          $user_attempt_update = $this->db->prepare( "UPDATE tat_user SET Failed_Count = NULL, Failed_First_Time = NULL WHERE Email=:uemail" );
          $user_attempt_update->execute( array( ':uemail'=>$uemail ) );
          return true;

        // User and password did not match, log attempt
        else :

          // This will be either the first attempt at a login, or a reset after being lockout
          if ( time() - $failed_first_time > $lockout_time ) :

            $failed_first_time = time();
            $failed_count = 1;
            // Commit to database
            $user_attempt_update = $this->db->prepare( "UPDATE tat_user SET Failed_Count = '$failed_count', Failed_First_Time = '$failed_first_time' WHERE Email=:uemail" );
            $user_attempt_update->execute( array( ':uemail'=>$uemail ) );

          else :

            $failed_count++;
            // Commit the update to database
            $user_attempt_update = $this->db->prepare( "UPDATE tat_user SET Failed_Count = '$failed_count' WHERE Email=:uemail" );
            $user_attempt_update->execute( array( ':uemail'=>$uemail ) );

          endif;

          return false;

        endif;

      endif;

    } catch ( PDOException $e ) {
      echo $e->getMessage();
    }
  }

  /*
   * Password recover
   * Check if user email exists
   */
  public function tat_recover_exists( $check_email ) {

    try {
      $stmt = $this->db->prepare( "SELECT * FROM tat_user WHERE Email=:email LIMIT 1" );
      $stmt->execute( array( ':email'=>$check_email ) );
      $userRow = $stmt->fetch( PDO::FETCH_ASSOC );

      if ( $stmt->rowCount() > 0 ) :
        return true;
      else :
        return false;
      endif;

    } catch ( PDOException $e ) {
      echo $e->getMessage();
    }

  }

  /*
   * Reset password link & email
   * - create and store a unique int token in db
   * - send email with link to reset password
   */
  public function tat_recover( $check_email ) {
    
    // Creates a random number between 0 and mt_getrandmax()
    $secure_token = mt_rand();
    echo $this->url . $this->reset_url . '?user=' . $check_email . '&token=' . $secure_token;

    try {
      $stmt = $this->db->prepare( "SELECT * FROM tat_user WHERE Email=:email LIMIT 1" );
      $stmt->execute( array( ':email'=>$check_email ) );
      $userRow = $stmt->fetch( PDO::FETCH_ASSOC );

      if ( $stmt->rowCount() > 0 ) :
        // Add random token to user table
        $add_user_token = $this->db->prepare( "UPDATE tat_user SET Token = $secure_token WHERE Email=:email" );
        $add_user_token->execute( array( ':email'=>$check_email ) );

        // Generate temp password, create email, and send email message
          $length = 10;
          $tmp_pass = random_str($length);
          $import = new Emailer();
          $import->sendRecoverEmail($check_email, $tmp_pass);

        return true;

      endif;

    } catch ( PDOException $e ) {
      echo $e->getMessage();
    }
  }

  /*
   * Password update
   * 
   */
  public function tat_pw_reset( $reset_email, $reset_pw, $reset_token ) {

    try {
      $stmt = $this->db->prepare( "SELECT * FROM tat_user WHERE Email=:email LIMIT 1" );
      $stmt->execute( array( ':email'=>$reset_email ) );
      $userRow = $stmt->fetch( PDO::FETCH_ASSOC );

      if ( $stmt->rowCount() > 0 ) :

        if ( $reset_token == $userRow['Token'] ) :

          // Need to hash and update Password column
          $reset_pw = password_hash( $reset_pw, PASSWORD_DEFAULT );
          $update_pw = $this->db->prepare( "UPDATE tat_user SET Password = $reset_pw WHERE Email=:email" );
          $update_pw->excute( array( ':email'=>$reset_email ) );

          // Need to set token to NULL
          $reset_token = $this->db->prepare( "UPDATE tat_user SET Token = NULL WHERE Email=:email" );
          $reset_token->execute( array( ':email'=>$reset_email ) );

          return true;

        else :
          return false;
        endif;
      endif;

    } catch ( PDOException $e ) {
      echo $e->getMessage();
    }
  }

  /*
   * Checks if user is logged in
   *
   */
  public function tat_is_loggedin() {
    
    if ( isset( $_SESSION['users_session'] ) ) :
      // Timeout time is 10min - 10 * 60sec = 600
      if ( $_SESSION['last_active'] - $_SESSION['login_time'] < 600 ) :
        $_SESSION['last_active'] = time();
        return true;
      else :
        $this->tat_logout();
      endif;
    endif;
    
  }
  
  /*
   * User logout
   * Destroy session and unset session variables
   */
  public function tat_logout() {

    session_destroy();
    // Unset session variables
    unset( $_SESSION['users_type'] );
    unset( $_SESSION['users_session'] );
    unset( $_SESSION['lockout_check'] );
    unset( $_SESSION['last_active'] );
    unset( $_SESSION['login_time'] );
    return true;

  }

    // PROJECT METHODS //

    /*
    * Get course data
    * Retrieves all course and course instance data
    */
    public function tat_get_course_data()
    {
        // get the courses in the following format course code, course name (course Year) - study period
        $stmt = $this->db->prepare("SELECT *, tat_course_instance.id
                                    FROM tat_course_instance
                                    INNER JOIN tat_course
                                    ON tat_course_instance.Course_Id=tat_course.Id
                                    ORDER BY tat_course.Title");
        $stmt->execute();
        $results  = $stmt->fetchAll();

        return $results;
    }

    /*
    * Get skills
    * Retrieves all skill data
    */
    public function tat_get_skills()
    {
        // get the courses in the following format course code, course name (course Year) - study period
        $stmt = $this->db->prepare("SELECT Id, Name FROM tat_skill");
        $stmt->execute();
        $results  = $stmt->fetchAll();

        return $results;

    }

    /*
    * Add new skill
    * Inserts skill data
    */
    public function tat_add_new_skill($value){
        $stmt = $this->db->prepare("INSERT INTO tat_skill (Name)
                                    VALUES(:Name)");

        $stmt->bindParam(':Name', $value);
        $stmt->execute();
    }

    /*
    * Create project
    * Inserts project data and associated project skills
    */
    public function tat_create_project($formData){
        // start by creating a new project
        $stmt = $this->db->prepare("INSERT INTO tat_project (Title, Type, Description, Manager_Id, Status, Size_Min, Size_Max)
                                    VALUES(:Title, :ProjectType, :Short_Description,:Manager_Id, :Status, :Size_Min, :Size_Max)");

        $stmt->bindParam(':Title', $formData['Title'] );
        $stmt->bindParam(':ProjectType', $formData['Type']);
        $stmt->bindParam(':Short_Description', $formData['Description']);

        $stmt->bindParam(':Manager_Id', $formData['Manager_Id']);
        $stmt->bindParam(':Status', $formData['Status']);
        $stmt->bindParam(':Size_Min', $formData['Size_Min']);
        $stmt->bindParam(':Size_Max', $formData['Size_Max']);


        $stmt->execute();


        // fetch the project id
        $stmt = $this->db->prepare("SELECT Id FROM tat_project WHERE Title = '" . $formData['Title'] . "' ");
        $stmt->execute();
        $res = $stmt->fetch();
        foreach($res as $Id){
            $id = $Id;
        }


        // insert the skills and project id into project requirements
        //first we explode the session that contains all the data

        foreach($formData['Skill_Id'] as $skill) {
            foreach($formData['skill-lvl'] as $key => $ll) {
                foreach($formData['skill-weight'] as $key2 => $ww) {
                    // and insert it
                    $stmt = $this->db->prepare("INSERT INTO tat_project_requirements (Skill_Id, Project_Id, Skill_Level, Weight)
                   VALUES('$skill', '$id', '$ll[$key]', '$ww[$key2]')");

                    $stmt->execute();
                    break;
                }
            }
        }

        //finally update the course project and reset all skill based sessions
        $stmt = $this->db->prepare("INSERT INTO tat_course_project (Course_Instance_Id, Project_Id) VALUES (:assoc_Id, :project_Id)");
        $stmt->bindParam(':assoc_Id', $formData['assoc_course']);
        $stmt->bindParam(':project_Id', $id);
        $stmt->execute();


        unset($_SESSION['all-skills']);unset($_SESSION['skills']);unset($_SESSION['a']);unset($_SESSION['insert-skills']);
    }

    /*
    * Display all courses
    * Retrieves a list of all courses instances and their respective course data
    */
    public function tat_display_all_courses(){
        $stmt = $this->db->prepare("SELECT   *
                                    FROM tat_course_project
                                    LEFT JOIN tat_course_instance ON tat_course_project.Course_Instance_Id = tat_course_instance.Id
                                    LEFT JOIN tat_course ON tat_course_instance.Course_Id = tat_course.Id
                                    group by tat_course_project.Course_Instance_Id");
        $stmt->execute();
        $results  = $stmt->fetchAll();

        //print_r($results);

        return $results;
    }

    /*
    * Display all projects
    * Retrieves a list of all projects and their respective course data
    */
    public function tat_display_all_projects(){
        $stmt = $this->db->prepare("SELECT *
                                    #FROM tat_project, tat_course_project, tat_course_instance
                                    #WHERE Project_Id = tat_project.Id AND Course_Instance_Id = tat_course_instance.Id
                                    FROM tat_course_project
                                    LEFT JOIN tat_project ON tat_course_project.Project_Id = tat_project.Id 
                                    LEFT JOIN tat_course_instance ON tat_course_instance.Id = tat_course_project.Course_Instance_Id");
        $stmt->execute();
        $results = $stmt->fetchAll();
        return $results;
    }

    /*
    * Count skills
    * Retrieves a count of all the skills assigned for a specific project id
    */
    public function tat_count_skills($var){
        $stmt = $this->db->prepare("SELECT COUNT(DISTINCT Skill_Id)
                                    FROM tat_project_requirements, tat_course_project
                                    WHERE tat_project_requirements.Project_Id =  $var
                                    AND tat_course_project.Project_Id = tat_project_requirements.Project_Id");


        $stmt->execute();
        $result = $stmt->fetch();

        foreach($result as $r){
            return $r;
        }

        return;

    }

    /*
    * Edit project
    * Retrieves the project and its associated skills for a specific project id
    */
    public function tat_edit_project($pid){
        $stmt = $this->db->prepare("SELECT *
                                    FROM tat_project, tat_project_requirements
                                    WHERE Id = $pid");

        $stmt->execute();
        $result = $stmt->fetchAll();


        return $result;

    }

    /*
    * Fetch skill
    * Retrieves a unique list of skills for a specific project id
    */
    public function tat_fetch_skill($pid){
        $stmt = $this->db->prepare("SELECT distinct * FROM tat_project_requirements
                                    LEFT JOIN tat_skill ON Id = Skill_Id
                                    WHERE Project_Id = $pid");
        $stmt->execute();
        $results = $stmt->fetchAll();
        return $results;
    }

    /*
    * Update edit
    * Updates the project and its associated skill details for a specific project id
    */
    public function tat_update_edit($formData, $pid){
        $stmt = $this->db->prepare("UPDATE tat_project
                                    SET
                                    Title=:Title,
                                    Type=:ProjectType,
                                    Description=:Short_Description,

                                    Manager_Id=:Manager_Id,
                                    Status=:Status,
                                    Size_Min=:Size_Min,
                                    Size_Max=:Size_Max
                                    WHERE Id = $pid");

        $stmt->bindParam(':Title', $formData['Title'] );
        $stmt->bindParam(':ProjectType', $formData['Type']);
        $stmt->bindParam(':Short_Description', $formData['Short_Description']);
        //$stmt->bindParam(':Long_Description', $formData['Long_Description']);
        $stmt->bindParam(':Manager_Id', $formData['Manager_Id']);
        $stmt->bindParam(':Status', $formData['Status']);
        $stmt->bindParam(':Size_Min', $formData['Size_Min']);
        $stmt->bindParam(':Size_Max', $formData['Size_Max']);


        $stmt->execute();

        // insert the skills and project id into project requirements
        //first we explode the session that contains all the data

        foreach($formData['Skill_Id'] as $skill) {
            foreach($formData['skill-lvl'] as $key => $ll) {
                foreach($formData['skill-weight'] as $key2 => $ww) {
                    // and insert it
                    $stmt = $this->db->prepare("INSERT INTO tat_project_requirements (Skill_Id, Project_Id, Skill_Level, Weight)
                   VALUES('$skill', '$pid', '$ll[$key]', '$ww[$key2]')");

                    $stmt->execute();
                    break;
                }
            }
        }





        unset($_SESSION['all-skills']);unset($_SESSION['skills']);unset($_SESSION['a']);unset($_SESSION['insert-skills']);

    }

    /*
    * Delete projects
    * Deletes a specific project id
    */
    public function tat_delete_project($pid){
        $stmt = $this->db->prepare("DELETE FROM tat_course_project WHERE Project_Id = $pid");
        $stmt->execute();

        header("Location: view-all-projects.php");
    }

    /*
    * Fetch project students
    * Retrieves a list of projects, students and associated skills for specific project id
    */
    public function tat_fetch_project_students($pid) {
        $stmt = $this->db->prepare("SELECT u.*, pu.Assigned_Skill_Id, s.Name AS 'Skill_Name'
                                    FROM tat_project_user AS pu
                                    LEFT JOIN tat_user AS u ON (pu.user_id=u.id)
                                    LEFT JOIN tat_skill s ON (pu.Assigned_Skill_Id=s.Id) 
                                    WHERE pu.project_id = $pid");

        $stmt->execute();
        $result = $stmt->fetchAll();

        return $result;
    }

    /*
    * Fetch student
    * Retrieves all the student details for a specific user id
    */
    public function tat_fetch_student($uid){
        $stmt = $this->db->prepare("SELECT * 
                                    FROM tat_user 
                                    WHERE Id = $uid");
        $stmt->execute();
        $results = $stmt->fetchAll();
        return $results;
    }


    /*
    * Calculate project difference
    * Retrieves the project difference value for a specific project id
    * In the future could be used to calculate the project difference as a percentage relative to other projects
    */
    public function tat_calc_project_difference($pid) {
        $stmt = $this->db->prepare("SELECT Project_Difference 
                                    FROM tat_project
                                    WHERE Id = $pid");
        $stmt->execute();
        $result = $stmt->fetch();

        // fetch the course id
        //$stmt = $this->db->prepare("SELECT Course_Instance_Id FROM tat_course_project WHERE Project_Id = $pid");
        //$stmt->execute();
        //$res = $stmt->fetch();
        //foreach($res as $CID){
            //$cid = $CID;
        //}

        // calculate the sum project difference of all projects in course instance
        //$stmt = $this->db->prepare("SELECT SUM(Project_Difference)  
                                    //FROM tat_course_project
                                    //WHERE Course_Instance_Id = $cid");
        //$stmt->execute();
        //$result_sum = $stmt->fetch();

        //if ($result == 0) {
          //return 100;
        //} else {
          foreach($result as $r) {
            //return ($r/10)*100;
            return $r;
          }
        //}

        return;

    }

    /*
    * Count allocated students
    * Retrieves the total number of students allocated to a specific project id
    */
    public function tat_count_allocated_students($pid){
        $stmt = $this->db->prepare("SELECT count(User_Id) 
                                    FROM tat_project_user 
                                    WHERE Project_Id = $pid");

        $stmt->execute();
        $result = $stmt->fetch();

        foreach($result as $r){
            return $r;
        }

        return;

    }

    /*
    * Update student
    * Updates the student details and associated skills for a specific user id
    */
    public function tat_update_student($formData, $sid){
        $stmt = $this->db->prepare("UPDATE tat_user
                                    SET
                                    Email=:Email 
                                    WHERE Id = $sid");

        $stmt->bindParam(':Email', $formData['Email'] );

        $stmt->execute();

        if ( isset($formData['skill-lvl']) ) {
          // insert the skills and user id into user_skills table
          foreach($formData['skill-lvl'] as $index => $value) {
            //echo $index . ":" . $value . "||";

            // use replace so it either inserts or updates values, depending on if they exist or not
            $stmt = $this->db->prepare("REPLACE INTO tat_user_skill (User_Id, Skill_Id, weight) VALUES('$sid', '$index', '$value')");

            $stmt->execute();
          }

          // once all the skills for the user have been replaced, update the skills_updated field
          $stmt = $this->db->prepare("UPDATE tat_course_student SET Skills_Updated='Yes' WHERE User_Id=$sid");

          $stmt->execute();

        }
    }

    /*
    * Fetch student skill
    * Retrieves the skills associate to a specific user id
    */
    public function tat_fetch_student_skill($uid) {
        $stmt = $this->db->prepare("SELECT DISTINCT * 
                                    FROM tat_user_skill AS us 
                                    LEFT JOIN tat_skill AS s ON (us.Skill_Id = s.Id) 
                                    WHERE us.User_Id = $uid");
        $stmt->execute();
        $results = $stmt->fetchAll();
        return $results;
    }

    /*
    * Fetch course project skills
    * Retrieves a unique list of project skills associated to an group of course instance ids
    */
    public function tat_fetch_course_project_skills($cids) {
        $stmt = $this->db->prepare("SELECT DISTINCT * 
                                    FROM tat_project_requirements AS pr 
                                    LEFT JOIN tat_course_project AS cp ON (pr.Project_Id = cp.Project_Id) 
                                    LEFT JOIN tat_skill AS s ON (pr.Skill_Id = s.Id) 
                                    WHERE cp.Course_Instance_Id in ($cids) 
                                    GROUP BY s.Id");
        $stmt->execute();
        $results = $stmt->fetchAll();
        return $results;
    }

    /*
    * Get student course data
    * Retrieves the course and course instance data for a specific user id
    */
    public function tat_get_student_course_data($sid) {
        // get the courses in the following format course code, course name (course Year) - study period
        $stmt = $this->db->prepare("SELECT ci.*, c.* 
                                    FROM tat_course_student AS cs
                                    LEFT JOIN tat_course_instance AS ci ON (cs.Course_Instance_Id=ci.Id) 
                                    INNER JOIN tat_course AS c ON (ci.Course_Id=c.Id) 
                                    WHERE cs.User_Id = $sid 
                                    ORDER BY ci.Year, ci.Study_Period ASC");
        $stmt->execute();
        $results  = $stmt->fetchAll();

        return $results;
    }

    /*
    * Update team status
    * Updates the status for a specific course instance id
    */
    public function tat_update_team_status($cid, $status) {
        $stmt = $this->db->prepare("UPDATE tat_course_instance 
                                    SET Status=:Status
                                    WHERE Id = $cid");

        $stmt->bindParam(':Status', $status);

        $stmt->execute();
    }

    /*
    * Update team app status
    * Updates the application status for a specific course instance id
    */
    public function tat_update_team_app_status($cid, $status) {
        $stmt = $this->db->prepare("UPDATE tat_course_instance 
                                    SET app_status=:Status
                                    WHERE Id = $cid");

        $stmt->bindParam(':Status', $status);

        $stmt->execute();
    }

    /*
    * Check team app status
    * Retrieves the application status for a specific course instance id
    */
    public function tat_check_team_app_status($cid) {
        $stmt = $this->db->prepare("SELECT app_status 
                                    FROM tat_course_instance 
                                    WHERE Id = $cid");

        $stmt->execute();
        $result = $stmt->fetch();

        foreach($result as $r){
            return $r;
        }

        return;

    }

    /*
    * Check team status
    * Retrieves the status for a specific course instance id
    */
    public function tat_check_team_status($cid) {
        $stmt = $this->db->prepare("SELECT status
                                    FROM tat_course_instance 
                                    WHERE Id = $cid");

        $stmt->execute();
        $result = $stmt->fetch();

        foreach($result as $r){
            return $r;
        }

        return;

    }

    /*
    * Get employee id
    * Retrieves the employee(student) number for a specific user id
    */
    public function tat_getEmpId($sid){
        $stmt = $this->db->prepare("SELECT employee_number FROM tat_user WHERE Id = '$sid'");
        $stmt->execute();
        $result = $stmt->fetch();
        return $result;
    }

}