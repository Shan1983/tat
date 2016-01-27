<?php
class CourseInstance 
{
    private $course_id, $year, $study_period, $status, $facilitator, 
            $projects_created, $location;
    
//     function __construct( $course_id, $year, $study_period, $facilitator, $location )
//     {
//         $this->course_id = $course_id;
//         $this->year = $year;
//         $this->study_period = $study_period;
//         $this->status = 'Inactive'; // default value
//         $this->facilitator = $facilitator;
//         $this->projects_created = 'No'; // default value
//         $this->location = $location;
//     }
    function __construct( )
    {
    	$this->course_id = '';
    	$this->year = '';
    	$this->study_period = '';
    	$this->facilitator = '';
    	$this->location = '';
    	$this->status = 'Inactive'; // default value
    	$this->projects_created = 'No'; // default value
    }
    
    /** 
    * check to see if course instance exists, checking study_period, year, and course_id
    * 
    * @param PDO db_con - database connection_aborted
    */
    public function check_instance_exists( $db_con )
    {
        $query = "SELECT * FROM `tat_course_instance` WHERE (`Course_Id` = :course_id AND `Year` = :year AND `Study_period` = :study_period)";
        
        try 
        {
            $statement = $db_con->prepare( $query );
            $statement->bindParam(':course_id', $this->course_id, PDO::PARAM_STR);
            $statement->bindParam(':year', $this->year, PDO::PARAM_STR);
            $statement->bindParam(':study_period', $this->study_period, PDO::PARAM_STR);
           
            $statement->execute();
            // if no match, fetch should be false
            if ( $statement -> fetch() )
            {
                // set error message and redirect
                $_SESSION['add_course_instance_error'] = 'The course instance you are attempting to add already exists in the system.';
                header('Location: ../add_course_instance_gui.php');
                die();
            }
        } catch ( PDOException $e )
        {
            $error = $e->getMessage();
            $_SESSION['add_course_instance_error'] = 'An error has occurred. Please contact system administrator. (Error: ' . $error . ')';
            header('Location: ../add_course_instance_gui.php');
            die();
        }    
    }
    
    /**
    * prepare and execute query for adding course instance to database
    * Status and Projects_created are default values of  'Inactive' and 'No'
    *
    * @param PDO db_con - database connection
    *
    */
    public function add_course_instance( $db_con )
    {
        $query = "INSERT INTO `tat_course_instance` 
                (`Course_Id`, `Year`, `Study_Period`, `Status`, `Facilitator`, `Projects_Created`, `Location`)
                VALUES (:course_id, :year, :study_period, :status, :facilitator, :projects_created, :location)";
        
        try{
            $statement = $db_con -> prepare( $query );
            $statement -> bindParam(':course_id', $this->course_id, PDO::PARAM_STR);
            $statement -> bindParam(':year', $this->year, PDO::PARAM_STR);
            $statement -> bindParam(':study_period', $this->study_period, PDO::PARAM_STR);
            $statement -> bindParam(':facilitator', $this->facilitator, PDO::PARAM_STR);
            $statement -> bindParam(':location', $this->location, PDO::PARAM_STR);
            $statement -> bindParam(':status', $this->status, PDO::PARAM_STR);
            $statement -> bindParam(':projects_created', $this->projects_created, PDO::PARAM_STR);
            
            $statement->execute();
            
            $_SESSION['course_instance_added'] = 1;
            header('Location: ../add_course_instance_gui.php');
            die();
            
        } catch ( PDOException $e )
        {
            $error = $e->getMessage();
            $_SESSION['add_course_instance_error'] = 'An error has occurred. Please contact system administrator. (Error: ' . $error . ')';
            header('Location: ../add_course_instance_gui.php');
            die();
        }
    }

    /**
    * Query for viewing all course instance
    *
    * @param PDO db_con - database connection
    *
    */
    public function view_course_instance( $db_con ) 
    {
        // Get all courses instances in order of year
        $viewCourseInstance = "SELECT tat_course.Id, tat_course.Code, tat_course.Title, tat_course_instance.Id AS Course_Instance_Id, tat_course_instance.Course_Id, tat_course_instance.Year, tat_course_instance.Study_Period, tat_course_instance.Study_Period, tat_course_instance.Status, tat_course_instance.Facilitator, tat_course_instance.Projects_Created, tat_course_instance.Location, tat_user.Id AS User_Id, tat_user.First_Name, tat_user.Last_Name FROM tat_course_instance, tat_course, tat_user WHERE `tat_course_instance`.`Course_Id`=`tat_course`.`Id` AND `tat_course_instance`.`Facilitator`=`tat_user`.`Id` ORDER BY `Year` ASC";
        foreach ( $db_con->query( $viewCourseInstance ) as $courseInstance ) : ?>
            <tr>
                <form action="" method="post"><?php
                // Hidden ?>
                <input type="hidden" name="Id" value="<?php echo $courseInstance['Course_Instance_Id'];?>">
                <td class="col-md-1"><?php echo $courseInstance['Code']; ?></td>
                <td class="col-md-4"><?php echo $courseInstance['Title']; ?></td>
                <td class="col-md-1"><?php echo $courseInstance['Year']; ?></td>
                <td class="col-md-1"><?php echo $courseInstance['Study_Period']; ?></td>
                <td class="col-md-1"><?php
                    $status = $courseInstance['Status'];
                    switch ( $status ) {
                        case 'inactive' : ?>
                            Inactive<br/>
                            <button name="activate" type="submit" class="btn btn-sm action btn-outline btn-primary">Activate</button><?php
                            break;
                        case 'active_incomplete' : ?>
                            Active<br/>
                            <button name="inactivate" type="submit" class="btn btn-sm action btn-outline btn-primary">Deactivate</button><?php
                            break;
                        case 'active_complete' : ?>
                            Complete <?php
                            break;
                        case 'interim' : ?>
                            Interim <?php
                            break;
                        default : ?>
                            Approved <?php
                            break;
                    } ?>
                </td>
                <td class="col-md-1"><?php echo $courseInstance['First_Name'] . ' ' . $courseInstance['Last_Name']; ?></td>
                <td class="col-md-1"><?php echo $courseInstance['Projects_Created']; ?></td>
                <td class="col-md-1"><?php echo $courseInstance['Location']; ?></td>
                </form>
<!--                 <td class="col-md-1"> -->
                    <!-- Edit Button -->
                   <!--  <p><a title="Edit Course" href="edit-course-instance.php?instanceId=<?php // echo $courseInstance['Course_Instance_Id']; ?>"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></a></p> -->
<!--                 </td> -->
            </tr><?php
        endforeach;
    }
    
    /**
    * Query for editing course instance
    *
    * @param PDO db_con - database connection
    *
    */
    public function edit_course_instance( $db_con )
    {
    }

    // accessors
    public function get_course_id(){
        return $this->course_id;
    }
    
	public function get_year() {
		return $this->year;
	}
	
	public function get_study_period() {
		return $this->study_period;
	}
    
    public function get_status() {
        return $this->status;
    }
    
    public function get_facilitator() {
        return $this->facilitator;
    }
    
    public function get_projects_created() {
        return $this->projects_created;
    }
    
    public function get_location() {
        return $this->location;
    }

	
	// mutators
    public function set_course_id($id) {
        $this->course_id = $id;
    }
    
	public function set_year($year) {
		$this->year = $year;
	}
	
	public function set_study_period($study_period) {
		$this->study_period = $study_period;
	}
    
    public function set_status($status) {
        $this->status = $status;
    }
    
    public function set_facilitator($facilitator) {
        $this->facilitator = $facilitator;
    }
    
    public function set_projects_created($projects_created) {
        $this->projects_created = $projects_created;
    }
    
    public function set_location($location) {
        $this->location = $location;
    }

}