<?php
require_once('user-db-config.php');
require_once('class_course.php');

// fetch form data
if(isset($_POST['do_add_course'])) {
    $title = $_POST['course_title'];
    $code = $_POST['course_code'];
    $short_desc = $_POST['course_short_desc'];

    if(empty($title)){
        $_SESSION['add_course_error'] = "Please give the course a title.";
        header('Location: ../add_course_gui.php');
    }else if(empty($code)){
        $_SESSION['add_course_error'] = "Please give the course a code.";
        header('Location: ../add_course_gui.php');
    }else if(empty($short_desc)){
        $_SESSION['add_course_error'] = "Please give the course a description.";
        header('Location: ../add_course_gui.php');
    }else{
        $new_course = new Course();
        
        $new_course.set_course_code($code);
        $new_course.set_course_title($title);
        $new_course.set_course_desc($short_desc);

        $new_course->check_course_exists($DB_con);

        $new_course->add_course($DB_con);
    }


}
