<?php

ini_set('display_errors',1);
error_reporting(E_ALL);
require_once('controller/user-db-config.php');
require_once('controller/class_change_Password.php');

$change = new ChangePassword($DB_con);

    if(isset($_POST['do_change'])){
        $old = $_POST['current'];
        $new = password_hash( $_POST['new'], PASSWORD_DEFAULT );

        //echo $change->verifyPassword($old);

        $chk = $change->verifyPassword($old);

        //echo $chk['Password'];

        if($old == $chk['Password']){
            $change->change_password($old, $new);
        }else{
            $error = "Could not find the current password entered!";
        }


    }

?>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4 col-md-offset-4 form-in-out">
            <form method="post">
                <div class="page-header">
                    <h2 class="form-signin-heading">Change Password</h2>
                </div><?php
                // Error message display on fail
                if ( isset( $error ) ) : ?>
                    <div class="alert alert-danger">
                    <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                    </div><?php
                endif;

                // Success message display
                if ( isset( $success ) ) : ?>
                    <div class="alert alert-success">
                    <i class="glyphicon glyphicon-ok"></i> &nbsp; <?php echo $success; ?>
                    </div><?php
                endif; ?>
                <div class="form-group">
                    <input type="password" class="form-control" name="current" placeholder="Current Password" required/>
                </div>
                <div class="form-group">
                    <input type="password" id="password" class="form-control" name="new" placeholder="New Password" required />
                </div>
                <div class="form-group">
                    <input type="password" id="password-confirm" class="form-control" name="new2" placeholder="Confirm Password" onChange="check_password_match();" required />
                </div>

                <button type="submit" class="btn btn-outline btn-primary" name="do_change">Change Password</button>
                <!-- Form message and button is part of reset-match.js -->
            </form>
        </div>
    </div><!-- /.row -->
</div><!-- /container -->