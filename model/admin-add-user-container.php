<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Add New User</h1>
		</div>
	</div><!-- /.row -->
    
     <?php
    // used to display a message if a user has been successfully added
    if ( isset($_SESSION['user_added']) ) {
        if ($_SESSION['user_added'] == 1) { ?>
            <div class="row">
                <div class="col-lg-12">
                    <div class="alert alert-success">
                        <i class="glyphicon glyphicon-ok"></i> &nbsp; <p>User added successfully!<p>
                    </div>
                </div>                 <!-- /.col-lg-12 -->
            </div>
    <?php 
        // unset $_SESSION['course_added']
        unset($_SESSION['user_added']);
        } 
    } ?>
    
    <?php 
    // used to display error to user
    // if value is set, show message for adding user errors
    if ( isset( $_SESSION['add_user_error'] ) ) {
        $error = $_SESSION['add_user_error'];
        ?>
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-danger">
                    <p>
                        <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                    </p>
                </div>
            </div>                 <!-- /.col-lg-12 -->
        </div>
    <?php unset( $_SESSION['add_user_error']); 
    } ?> 
    
	<div class="row">
		<div class="col-lg-9">
			<form role="form" method="post" action="controller/add_user.php" >
				<div class="row">
					<div class="col-lg-9">
                        <div class="form-group">
                            <label>Student Number</label>
                            <input type="text" name="sid" class="form-control" placeholder="Enter new user's student number" required>
                        </div>
						<div class="form-group">
							<label>First Name</label>
							<input type="text" name="first_name" class="form-control" placeholder="Enter new user's first name" required>
						</div>

                        <div class="form-group">
                            <label>Last Name</label>
                            <input type="text" name="last_name" class="form-control" placeholder="Enter new user's last name" required>
                        </div>
                        
                        <div class="form-group">
                            <label>E-mail</label>
                            <input type="email" name="user_email" class="form-control" placeholder="Enter a valid e-mail address" required>
                        </div>
                        
                        <div class="form-group">
                            <label>Phone number</label>
                            <input type="text" name="phone_number" class="form-control" placeholder="Enter users contact phone number" required>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label>Gender</label>
                            <select name="gender" class="form-control" required>
                                <option name="gender" value="">--Please select a gender--</option>
                                <option name="gender" value="male">Male</option>
                                <option name="gender" value="female">Female</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label>User Type</label>
                            <select name="user_type" class="form-control" required>
                                <option name="user_type" value="">--Please select a user type--</option>
                                <option name="user_type" value="student">Student</option>
                                <option name="user_type" value="lecturer">Lecturer</option>
                                <option name="user_type" value="admin">Administrator</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label>Student GPA</label>
                            <input type="text" name="student_gpa" class="form-control" placeholder="Leave blank for lecturers/admins">
                        </div>
                    </div>
                </div>
                
               
                <div class="row">
                    <div class="col-lg-9">
                    
                    <!-- DO NOT USE THIS AT THIS TIME
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" placeholder="Enter a password" required>
                        </div>
                        
                        <div class="form-group">
                            <label>Confirm Password</label>
                            <input type="password" name="password_confirm" class="form-control" placeholder="Re-enter the exact password" required>
                        </div>
                    -->

                        <button type="submit" name="do_add_user" class="btn btn-outline btn-primary">Add User</button>
                    </div>
                </div>
			
            </form> <!-- end of self submit form -->
        </div>
        
    </div><!-- /.row (nested) -->
</div><!-- /.page-wrapper -->