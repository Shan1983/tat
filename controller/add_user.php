<?php
require_once ('user-db-config.php');
require ('random_string.php');
require ('Emailer.php');

// collect form data
if (isset ( $_POST ['do_add_user'] )) {
	$student_id = $_POST ['sid'];
	$first_name = $_POST ['first_name'];
	$last_name = $_POST ['last_name'];
	$email = $_POST ['user_email'];
	$phone_number = $_POST ['phone_number'];
	$gpa = isset ( $_POST ['student_gpa'] ) ? $_POST ['student_gpa'] : "0.0";
	$gender = $_POST ['gender'];
	$access_level = $_POST ['user_type'];
	
	if (empty ( $student_id )) {
		$_SESSION ['add_user_error'] = "Please enter the users number.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $first_name )) {
		$_SESSION ['add_user_error'] = "Please enter the users name.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $last_name )) {
		$_SESSION ['add_user_error'] = "Please enter the users surname.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $email )) {
		$_SESSION ['add_user_error'] = "Please enter the users email.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $phone_number )) {
		$_SESSION ['add_user_error'] = "Please enter the users contact number.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $gender )) {
		$_SESSION ['add_user_error'] = "Please enter the users gender.";
		header ( 'Location: ../add_user_gui.php' );
	} else if (empty ( $access_level )) {
		$_SESSION ['add_user_error'] = "Please enter the users user type.";
		header ( 'Location: ../add_user_gui.php' );
	}
	

	$new_user = new User($student_id, $first_name, $last_name, $email,
			$phone_number, $gpa, $gender, $access_level);
	
	$new_user.check_user_exists($DB_con);
	
	$new_user.add_user($DB_con);
}


