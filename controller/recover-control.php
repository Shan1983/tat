<?php
/*
 * Password Recovery
 *
 */
if ( $user->tat_is_loggedin() != '' ) :
  header('Location: dashboard.php');
endif;

if ( isset( $_POST['btn-reset'] ) ) :

	if ( '' == $_POST['txt_honey_pot'] ) :

		$check_email = filter_input( INPUT_POST, 'txt_user_email', FILTER_SANITIZE_SPECIAL_CHARS );

		// Check if email exists
		if ( true === $user->tat_recover_exists( $check_email ) ) :
			// Send recovery email
			if ( true === $user->tat_recover( $check_email ) ) :
				$success = 'Please check your email to reset password.';
			endif;
		else : 
			$error = 'That email is not registered to a user.';
		endif;

	else :
		// We caught em in the honey pot field
		// Let's not do anything and keep the bots guessing
	endif;

endif;