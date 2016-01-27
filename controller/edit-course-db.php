<?php
// Need to get the new values to add to database
if ( ! empty( $_POST ) ) :
    // Get Id value from form
    $id = isset($_POST['edit_course']) ? $_POST['edit_course'] : null;
    // Validation errors
    $codeError = null;
    $titleError = null;
    $descError = null;
     
    // Course values
    $code = isset($_POST['code']) ? $_POST['code'] : null;
    $title = isset($_POST['title']) ? $_POST['title'] : null;
    $description = isset($_POST['description']) ? $_POST['description'] : null;
     
    // Validate
    $valid = true;
    // Course code
    if ( empty( $code ) ) :
        $codeError = 'Please enter the course code';
        $valid = false;
    endif;
    // Course title 
    if ( empty( $title ) ) :
        $titleError = 'Please enter the course title';
        $valid = false;
    endif;
    // Course short description 
    if ( empty( $description ) ) :
        $descError = 'Please enter the short course description';
        $valid = false;
    endif;
    // update data
    if ( true === $valid ) :
    	// retrieve Id again after new submition as origin $_POST will be replaced
   		$id = $_POST['Id'];
    	$editCourse = $DB_con->prepare( "UPDATE tat_course SET Code=:code, Title=:title, Description=:description WHERE Id=:id" );
    	$editCourse->execute( array( ':code'=>$code, ':title'=>$title, ':description'=>$description, 'id'=>$id ) );
        header("Location: view-courses.php");
    endif;
endif;
