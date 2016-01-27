<?php

// retrieve the user/student id from the session information saved on login
$sid = $_SESSION['users_session'];

// get the employee number, as the user_id is for internal use only
$eid = $user->tat_getEmpId($sid);

// check if update button was submitted
if(isset($_POST['do_update_student'])){
    // get the form data ready to be sent for inserting
    $formData = array();
    $formData['Email'] = $_POST['txt-student-email'];

	// check if any skill information exists
	if ( isset($_POST['txt-skill-lvl']) ) {
		$formData['skill-lvl'] = $_POST['txt-skill-lvl'];
	}

    // check for a valid student id
    if (empty($sid) || $sid == '') {
        $error = "You must specify a <b>Student ID</b> when updating a profile.";
    } else {
    	// update the student profile and related skills
    	$success = "Student profile has been successfully updated.";
        $user->tat_update_student($formData, $sid);
    }
    unset($_POST);
}
?>
<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Student Profile</h1>
		</div>
	</div><!-- /.row -->
	<div class="row">
        <?php 
        // retrieve the student info for the current student id
        foreach($user->tat_fetch_student($sid) as $student) { ?>
		<div class="col-lg-9">
			<form role="form" method="post">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
                            <?php if ( isset( $error ) ) : ?>
                                <div class="alert alert-danger">
                                    <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                                </div>
                            <?php endif; ?>
                            <?php if ( isset( $success ) ) : ?>
                            	<div class="alert alert-success">
                            		<strong>Success!</strong> <?php echo $success; ?>
                            	</div>
                            <?php endif; ?>
                            <label>Student ID:</label> <?php echo $eid['employee_number']; ?>
						</div>
						<div class="form-group">
                            <label>Student Name:</label> <?php echo $student['Last_Name'] . ", " . $student['First_Name']; ?>
						</div>
						<div class="form-group">
                            <label>Student Email Address</label>
							<input type="email" class="form-control" placeholder="" name="txt-student-email" value="<?php echo $student['Email']; ?>" required>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="form-group">
							<label>Associate Course(s)</label>
                                <?php
                                // array of course instances
                                $cids = array();
                                
                                // loop through all the course instances the student is assigned to
                                foreach($user->tat_get_student_course_data($sid) as $data) {
                                    //echo "<pre>" . var_dump($data) . "</pre>";
                                    echo "<p>" . $data['Code'] . " " . $data['Title'] . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. " <b>(" . $data['Status'] . ")</b></p>";
                                    // update the array of course instances, used later when retrieving skills
                                    $cids[] = $data[0];
                                }?>
						</div>
					</div>
				</div>
				<div class="row">
				</br></br>
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							Skills &amp; Competencies
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-hover">
									<thead>
										<tr>
											<th width="50%">Skill Name</th>
											<th width="50%">Skill Level</th>
										</tr>
									</thead>
									<?php
									// check to see array of course instances is populated with at least one course instance id
									if ($cids) {?>
									<tbody>
                                        <?php
                                        // loop through all skills for all projects assigned to the course instances array
                                        foreach($user->tat_fetch_course_project_skills( implode(",", $cids) ) as $cps) {?>
                                            <tr>
                                                <td><?php echo $cps['Name']; ?></td>
                                                <td>
                                                <?php 
                                                $set_skill_level = "";
                                                // loop through all associated student skills and set selection from dropdown
                                                foreach($user->tat_fetch_student_skill($sid) as $s) {
                                                	if ($s['Skill_Id'] == $cps['Skill_Id']) {
                                                		$set_skill_level = $s['weight'];
                                                	}
                                                }?>
												<select class="form-control" name="txt-skill-lvl[<?php echo $cps['Skill_Id']; ?>]">
													<option>None</option>
													<option value="Beginner" <?php if ($set_skill_level == "Beginner") { echo "selected"; } ?>>Beginner (1-6 mth)</option>
													<option value="Intermediate" <?php if ($set_skill_level == "Intermediate") { echo "selected"; } ?>>Intermediate (6-12 mth)</option>
													<option value="Advanced" <?php if ($set_skill_level == "Advanced") { echo "selected"; } ?>>Advanced (1-3 yrs)</option>
													<option value="Expert" <?php if ($set_skill_level == "Expert") { echo "selected"; } ?>>Expert (3+ yrs)</option>
												</select>
                                                </td>
                                            </tr>
                                        <?php } ?>
									</tbody>
									<?php } ?>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<button type="submit" class="btn btn-outline btn-primary" name="do_update_student">Update Profile</button>
		</form>
	</div>
	<!-- /.row (nested) -->
	<?php break; } ?>
</div><!-- /.page-wrapper -->