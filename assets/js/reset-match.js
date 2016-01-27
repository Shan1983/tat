/*
 * Checks user input in each password field match
 * returns error or success message
 */
function check_password_match() {

    var password = $("#password").val();
    var confirmPassword = $("#password-confirm").val();

    var noMatch = '<div class="alert alert-danger" role="alert"><i class="glyphicon glyphicon-warning-sign"></i> &nbsp; Passwords do not match!</div>';

    var success = '<div class="alert alert-success" role="alert"><i class="glyphicon glyphicon-ok"></i> &nbsp; Passwords match.</div><div class="clearfix"></div><div class="form-group"><button type="submit" name="btn-reset" class="btn btn-lg btn-success btn-block">Reset Password</button></div>';

    if ( password != confirmPassword ) {
        $('#check-password').html( noMatch );
    } else {
        $('#check-password').html( success );
    }
}

$(document).ready(function() {
   $("#password-confirm").keyup(check_password_match);
});
