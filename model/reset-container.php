<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-4 col-md-offset-4 form-in-out">
      <form method="post">
        <div class="page-header">
          <h2 class="form-signin-heading">Reset Password</h2>
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
          <input type="text" class="form-honey-pot" name="reset_honey_pot" />
        </div>
        <div class="form-group">
          <input type="password" id="password" class="form-control" name="txt_password_init" placeholder="Password" required />
        </div>
        <div class="form-group">
          <input type="password" id="password-confirm" class="form-control" name="reset_password" placeholder="Confirm Password" onChange="check_password_match();" required />
        </div>
        <div class="password-alert" id="check-password"></div>
        <!-- Form message and button is part of reset-match.js -->
      </form>
    </div>
  </div><!-- /.row -->
</div><!-- /container -->