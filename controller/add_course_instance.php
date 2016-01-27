<?php 
require_once('user-db-config.php');
require_once('class_course_instance.php');

if(isset($_POST['do_add_instance'])) {
// fetch form data
    $course_id = $_POST['course_selection'];
    $facilitator = $_POST['course_facilitator'];
    $delivery_method = $_POST['delivery_method'];
    $year = $_POST['course_year'];
    $study_period = $_POST['course_study_period'];

    if(empty($course_id)){
        $_SESSION['add_course_instance_error'] = "Please select a course";
        header('Location: ../add_course_instance_gui.php');
    }else if(empty($facilitator)){
        $_SESSION['add_course_instance_error'] = "Please select a facilitator";
        header('Location: ../add_course_instance_gui.php');
    }else if(empty($delivery_method)){
        $_SESSION['add_course_instance_error'] = "Please select a delivery method";
        header('Location: ../add_course_instance_gui.php');
    }else if(empty($year)){
        $_SESSION['add_course_instance_error'] = "Please select a year";
        header('Location: ../add_course_instance_gui.php');
    }else if(empty($study_period)){
        $_SESSION['add_course_instance_error'] = "Please select a study period";
        header('Location: ../add_course_instance_gui.php');
    }

// create a class object
    $course_instance = new CourseInstance();
    
    $course_instance.set_course_id($course_id);
    $course_instance.set_facilitator($facilitator);
    $course_instance.set_study_period($study_period);
    $course_instance.set_year($year);
    $course_instance.set_location($delivery_method);

// check if exists
    $course_instance->check_instance_exists($DB_con);

// add to database
    $course_instance->add_course_instance($DB_con);
}
