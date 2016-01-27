<?php
require_once('class_course_instance.php');
	// Instantiate the CourseInstance class
	$courseInstance = new CourseInstance();
	$courseInstance->edit_course_instance( $DB_con );