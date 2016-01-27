<?php
/*
 * Password Reset
 *
 */
if ( $user->tat_is_loggedin() != '' ) :
  header('Location: dashboard.php');
endif;

// Vars from url
$reset_email = $_GET['user'];
$reset_token = $_GET['token'];

if ( isset( $_POST['btn-reset'] ) ) :

	if ( '' == $_POST['reset_honey_pot'] ) :
		// New pw from from
		$reset_pw = filter_input( INPUT_POST, 'reset_password', FILTER_SANITIZE_SPECIAL_CHARS );
		// Pass all the vars to function
		if ( true === $user->tat_pw_reset( $reset_email, $reset_pw, $reset_token ) ) : 
			$success = 'Your password has successfully reset.';
		else :
			$error = 'Sorry, something is wrong with your information, please contact the course administration.'; 
		endif;
	else :
		// We caught em in the honey pot field
		// Let's not do anything and keep the bots guessing
	endif;

endif;