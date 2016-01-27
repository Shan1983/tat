<div class="container">
  <div class="row">
    <div class="col-xs-12 col-md-4 col-md-offset-4 form-in-out">
      <form method="post">
        <div class="page-header">
          <h2 class="form-signin-heading">Password Recovery</h2>
          <p>Enter your email address and we will email you a link that will enable you to reset your password securely.</p>
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
          <input type="text" class="form-honey-pot" name="txt_honey_pot" />
        </div>
        <div class="form-group">
          <input type="text" class="form-control" name="txt_user_email" placeholder="Your Email Address" required />
        </div>
        <div class="clearfix"></div>
        <div class="form-group">
          <button type="submit" name="btn-reset" class="btn btn-lg btn-success btn-block">Reset My Password</button>
        </div>
      </form>
    </div>
  </div><!-- /.row -->
</div><!-- /container -->