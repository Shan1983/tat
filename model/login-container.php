<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-4 col-md-offset-4 form-in-out">
      <form method="post">
        <div class="page-header">
          <h2 class="form-signin-heading">Login</h2>
        </div><?php

        // Error message display on login fail    
        if ( isset( $error ) ) : ?>
          <div class="alert alert-danger">
              <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
          </div> <?php
        endif; ?>
        <div class="form-group">
          <input type="text" class="form-honey-pot" name="txt_honey_pot" />
        </div>
        <div class="form-group">
          <input type="text" class="form-control" name="txt_uname_email" placeholder="User Email" required />
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="txt_password" placeholder="Password" required />
        </div>
        <div class="clearfix"></div>
        <div class="form-group">
          <button type="submit" name="btn-login" class="btn btn-lg btn-success btn-block">Sign In</button>
        </div>
      </form>
      <div class="reset-container">
        <p>Forgot your password?</p>
        <p><a title="Click here to reset" href="recover.php">Click here to reset.</a></p>
      </div><!-- /.reset-container -->
    </div>
  </div><!-- /.row -->
</div><!-- /container -->