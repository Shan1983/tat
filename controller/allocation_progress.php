<?php
require_once('user-db-config.php');

// executes the process in the background so that the rest of the script runs
function bgExec($cmd) {
    if(substr(php_uname(), 0, 7) == "Windows") {
        pclose(popen("start /B ". $cmd, "r"));
    } else {
        exec($cmd . " > /dev/null &");
    }
}

// update the app_status to prevent issues if a team has already been allocated
$user->tat_update_team_app_status($_SESSION['create-team-cid'], "");

// call the java app that starts the algorithm
// this is the best place to run this function as it's triggered once by the startAllocation javascript function
bgExec($_SESSION['create_team_exec_path']);

// recommended to prevent caching of event data.
header('Content-Type: text/event-stream');
header('Cache-Control: no-cache'); 

// sends the message to the receiving page
// previous version included flush() functionality, but this was removed due to 
// production server incompatibility
function send_message($id, $message, $progress) {
    $d = array('message' => $message , 'progress' => $progress);
      
    echo "id: $id" . PHP_EOL;
    echo "data: " . json_encode($d) . PHP_EOL;
    echo PHP_EOL;
}

// allow time for algorithm to initialise
sleep(10);

// continues the progress monitor for the max runtime value
for ($i = 1; $i <= ($_SESSION['create-team-runtime']/5); $i++) {
	// checks to see if there is any new application status
    $app_status = $user->tat_check_team_app_status($_SESSION['create-team-cid']);

	//echo $app_status;
	
    // checks to see if the application status has completed
    // this needs to be changed to match the values sent by the application
	if ($app_status <> "") {
		break;
	} else {
    	sleep(5);
    }
}

// checks to see if the application status has completed
// you should only get to this point if the max runtime is reached
if ( $app_status == "Normal_Exit" ) {
    send_message('COMPLETE', 'Process complete','');
} else if ( $app_status <> "" ) {
    send_message('CLOSE', 'Error: ' . $app_status . '. Click <b>Cancel</b> to create a new balanced team.','');
} else {
    send_message('CLOSE', 'Max runtime limit has been reached and the algorithm did not generate results. Click <b>Cancel</b> to create a new balanced team.','');
}
?>