<?php 
class Course 
{
	// course class attributes
    private $title, $code, $description;
    
    /**
     * Default class constructor
     */
    function __construct ()
    {
        $this->title = '';
        $this->code = '';
        $this->description =  '';

    }
    
    /**
    * Check if course already exists in database.
    * 
    * @param $DB_con - database connection object
    */
    public function check_course_exists($DB_con) 
    {
        $query_str = "SELECT * FROM `tat_course` WHERE `Code` = :code";
        
        try
        {
            $statement = $DB_con -> prepare( $query_str );
            $statement -> bindParam( ':code', $this->code, PDO::PARAM_STR );
            $statement -> execute();
        
            // if no match it found, fetch is false
            if( $statement->fetch() ) 
            {
                // set error message and redirect
                $_SESSION['add_course_error'] = 'The course you are attempting to add already exists in the system.';
                header('Location: ../add_course_gui.php');
                die();
            }
        } catch ( PDOException $e )
        {
            $error = $e->getMessage();
            $_SESSION['add_course_error'] = 'An error has occurred. Please contact system administrator. (Error: ' . $error . ')';
            header('Location: ../add_course_gui.php');
            die();
        }
    }
    
    /**
    * Prepare and run query to add course to database.
    * 
    * @param $DB_con - database connection object
    */
    public function add_course($DB_con)
    {
        $query = "INSERT INTO `tat_course` (`Code`, `Title`, `Description`) VALUES (:code, :title, :description)";
        
        try
        {
            $statement = $DB_con -> prepare( $query );
            $statement->bindParam(':code', $this->code, PDO::PARAM_STR);
            $statement->bindParam(':title', $this->title, PDO::PARAM_STR);
            $statement->bindParam(':description', $this->description, PDO::PARAM_STR);

            
            $statement->execute();
            
            $_SESSION['course_added'] = 1;
            header('Location: ../add_course_gui.php');
            die();    
        } catch ( PDOException $e )
        {
            $error = $e->getMessage();
            $_SESSION['add_course_error'] = 'An error has occurred. Please contact system administrator. (Error: ' . $error . ')';
            header('Location: ../add_course_gui.php');
            die();
        }
    }

    /**
    * Prepare and run query to view all courses
    * 
    * @param $DB_con - database connection object
    */
    public function view_courses( $DB_con )
    {
        // Get all courses in order of Title in alphabetical order
        $viewCourse = "SELECT * FROM `tat_course` ORDER BY `tat_course`.`Title` ASC";
        foreach ( $DB_con->query( $viewCourse ) as $course ) : ?>
            <tr>
                <th class="col-md-1"><?php echo $course['Code']; ?></th>
                <td class="col-md-5"><?php echo $course['Title']; ?></td>
                <td class="col-md-5"><?php echo $course['Description']; ?></td>
                <td class="col-md-1">
                    <!-- Edit Button -->
                    <p><a title="Edit Course" href="edit-course.php?id=<?php echo $course['Id']; ?>"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></a></p>
                </td>
            </tr><?php
        endforeach;
    }

    /**
    * Edit course
    * 
    * @param PDO DB_con - database connection 
    */
    public function edit_course( $DB_con )
    {
        // The course Id from url
        if ( isset( $_POST['edit-course'] ) ) :
            $id = $_POST['edit_course'];
        else :
            $id = isset($_GET['id']) ? $_GET['id'] : null;
        endif;
        // If id is empty, show search box else show edit course
        if ( !isset($id) ) : ?>
            <form action="" method="post">
                <label for="edit_course">Select Course</label>
                <select name="edit_course" id="edit_course" class="form-control" required>
                    <option name="edit_selection" value=""></option><?php

                    $editCourse = "SELECT * FROM tat_course";
                    foreach ( $DB_con->query( $editCourse ) as $course ) : ?>
                        <option name="edit_selection" value="<?php echo $course['Id']; ?>"><?php echo $course['Code'] . ' - ' . $course['Title'] ?></option><?php
                    endforeach; ?>

                </select><br/>
                <button name="edit-course" type="submit" class="btn btn-outline btn-primary">Edit Course</button>
            </form><?php
        else : 
            $editCourse = $DB_con->prepare( "SELECT * FROM tat_course WHERE Id=:id LIMIT 1" );
            $editCourse->execute( array( ':id'=>$id ) );
            $courseRow = $editCourse->fetch( PDO::FETCH_ASSOC );
            // Check if course exists
            if ( $editCourse->rowCount() > 0 ) : ?>
                <form action="" method="post"><?php 
                    // Hidden id ?>
                    <input type="hidden" name="Id" value="<?php echo $courseRow['Id'] ?>"><?php
                    // Code input ?>
                    <div class="form-group">
                        <label>Code</label>
                        <input type="text" name="code" class="form-control" placeholder="Code" value="<?php echo ! empty( $courseRow['Code'] ) ? $courseRow['Code'] : ''; ?>" required>
                    </div><?php
                    // Title input ?>
                    <div class="form-group">
                        <label>Title</label>
                        <input type="text" name="title" class="form-control" placeholder="Title" value="<?php echo ! empty( $courseRow['Title'] ) ? $courseRow['Title'] : ''; ?> " required>
                    </div><?php
                    // Short description input ?>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea type="text" name="description" class="form-control" placeholder="Write a course description here." rows="5" required><?php echo ! empty( $courseRow['Description'] ) ? $courseRow['Description'] : ''; ?></textarea>
                    </div>
                    <button name="edit-course-update" type="submit" class="btn btn-outline btn-primary">Update Course</button>
                </form><?php
            endif;
        endif;
    }

    /**
    * accessors
    */
	public function get_course_code() {
		return $this->code;
	}
	
	public function get_course_name() {
		return $this->title;
	}
    
    public function get_short_desc() {
        return $this->description;
    }
    
    public function get_long_desc() {
        return $this->long_desc();
    }
	
    /**
    * mutators
    */
	public function set_course_code($code) {
		$this->code = $code;
	}
	
	public function set_course_name($name) {
		$this->title = $name;
	}
    
    public function set_short_desc($short_desc) {
        $this->description = $short_desc;
    }
    

    
}