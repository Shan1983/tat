<?php
	require_once( 'controller/user-db-config.php' );
	$user->tat_logout(); ?>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4 ">
			<div class="page-header">
			  <h2>Logged Out</h2>
			</div>
			  <p><a class="btn btn-lg btn-success btn-block" href="login.php" role="button">Would you like to login?</a></p>
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->