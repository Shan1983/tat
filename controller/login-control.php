<?php
if ( ! $user->tat_is_loggedin() ) :
	header('Location: login.php');
endif;