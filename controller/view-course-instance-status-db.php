<?php
// Need to get the new status to add to database
if ( ! empty( $_POST ) ) :
	$id = $_POST['Id'];
	// Need to get the new values to add to database
	if ( isset( $_POST['activate'] ) ) :
		// Status Active = active_incomplete
		$status = 'active_incomplete';
	else :
		$status = 'inactive';
	endif;
	$activateInstance = $DB_con->prepare( "UPDATE tat_course_instance SET Status=:status WHERE Id=:id" );
	$activateInstance->execute( array( ':status'=>$status, 'id'=>$id ) );
	header("Location: view-course-instances.php");
endif;



