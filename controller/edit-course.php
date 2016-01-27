<?php
require_once('class_course.php');
// Instantiate the Course class
$courses = new Course();
$courses->edit_course( $DB_con ); 
?>