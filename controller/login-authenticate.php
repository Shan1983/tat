<?php
if ( $user->tat_is_loggedin() != '' ) :
  header('Location: dashboard.php');
endif;

if ( isset( $_POST['btn-login'] ) ) :

	if ( '' == $_POST['txt_honey_pot'] ) :

		$uemail = filter_input( INPUT_POST, 'txt_uname_email', FILTER_SANITIZE_SPECIAL_CHARS );
		$upass = filter_input( INPUT_POST, 'txt_password', FILTER_SANITIZE_SPECIAL_CHARS );


	  if ( $user->tat_login( $uemail , $upass ) ) :
	  	header('Location: dashboard.php');
	  elseif ( 3 == $_SESSION['lockout_check'] ):
	    $error = 'You have failed on 3 attempts to login, you have been locked out for 10 minutes!';
	  else :
	  	$error = 'Those details are not correct, please try again!';
	  endif;

	else :
		// We caught em in the honey pot field
		// Let's not do anything and keep the bots guessing
  endif;

endif;