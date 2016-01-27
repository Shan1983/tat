<?php
require_once('user-db-config.php');

//$algorithm_path = "C://xampp/htdocs/tat/tat_app.jar";
$algorithm_path = "/opt/bitnami/apache2/htdocs/tat_app.jar";

// retrieves the selected course instance 
$_SESSION['create-team-cid'] = "";
$_SESSION['create-team-cid'] = $_POST['txt-select-course-instance'];

// retrieves the selected max runtime value
$_SESSION['create-team-runtime'] = $_POST['txt-max-runtime'];

// check if the create team button was submitted
if (isset($_POST['do_create_teams'])) {

    // check to see if team allocation already exists
    $course_allocation_status = $user->tat_check_team_status($_POST['txt-select-course-instance']);

    // check for edge cases
    if ($_POST['txt-select-course-instance'] == 0) {
        // check to see a course instance has been selected
        $_SESSION['create_team_error'] = "Please select a <b>Course to Allocate</b> from the drop down.";
        header('Location: ../create-balanced-teams-gui.php');
        exit;
    } else if ($course_allocation_status == "Active - Incomplete") {
        // check to see if a course instance is incomplete
        $_SESSION['create_team_error'] = "This course is marked as <b>Active - Incomplete</b> and is not ready for team creation. Please ensure all students for this course update their skills.";
        header('Location: ../create-balanced-teams-gui.php');
        exit;
    } else {

        // retrieve the variables required to run the external algorithm function
        // we do this here to cover case when existing allocation exists and user chooses to create new
        foreach($user->tat_get_course_data() as $data) {
            if ($data[0] == $_POST['txt-select-course-instance']) {
                $course_code = $data['Code'];
                $course_year = $data['Year'];
                $course_period = $data['Study_Period'];
            }
        }

        // saves the full exec path and passed parameters to a session variable
        $_SESSION['create_team_exec_path'] = "java -jar " . $algorithm_path . " " . $course_code . " " . $course_year . " " . $course_period . " " 
                . $_POST['txt-select-allocation-method'] . " " .  $_POST['txt-max-runtime'];

        // display modal prompt if the allocation state is interim or approved
        if ($course_allocation_status == "Interim") {
            // check to see if a course instance is interim
            header('Location: ../create-balanced-teams-gui.php?modal=interim');
            exit;
        } else if ($course_allocation_status == "Approved") {
            // check to see if a course instance is Approved
            header('Location: ../create-balanced-teams-gui.php?modal=approved');
            exit;
        } else {
            // if we've got to here we just need to check the file exists before proceeding
            if (!file_exists($algorithm_path)) {
                $_SESSION['create_team_error'] = "The selected <b>Algortihm Method</b> file or path does not exist. Please contact the system administrator.";
                header('Location: ../create-balanced-teams-gui.php');
                exit;
            } else {
                // redirect to the page that runs algorithm and checks progress
                header('Location: ../create-team-progress-gui.php');
                exit;
            }
        } 
    }
}

// check if the view allocation button was submitted
if (isset($_POST['do_view_allocation'])) {

    // check to see if team allocation already exists
    $course_allocation_status = $user->tat_check_team_status($_POST['txt-select-course-instance']);

	// check for edge cases
    if ($_POST['txt-select-course-instance'] == 0) {
        // check course instance has been selected from dropdown
        $_SESSION['create_team_error'] = "Please select a <b>Course to Allocate</b> from the drop down.";
        header('Location: ../create-balanced-teams-gui.php');
        exit;
    } else if ( ($course_allocation_status <> "Interim") && ($course_allocation_status <> "Approved") ) {
        // check if results actually exist
        $_SESSION['create_team_error'] = "There are no teams created for this course instance. You will need to <b>Create Teams</b> first.";
        header('Location: ../create-balanced-teams-gui.php');
        exit;
    } else {
        // redirect to results page
        header('Location: ../allocated-teams-gui.php?cid=' . $_POST['txt-select-course-instance']);
        exit;
    }
}
?>