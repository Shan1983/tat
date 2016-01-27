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

// add new skill
if(isset($_POST['do_add_skill'])){
    $_SESSION['new_skill_added'] = "<td><label>Enter new skill name:</label></td>
<td><input class='form-control' name='new-skill-name'></td>
<td><button type='submit' class='btn btn-outline btn-primary' name='do_add_it'>Add skill</button></td><td></td>";
}

if(isset($_POST['do_add_it'])){
    if(!empty($_POST['new-skill-name'])){
        $user->tat_add_new_skill($_POST['new-skill-name']);
        unset($_SESSION['new_skill_added']);
    }else{
        unset($_SESSION['new_skill_added']);
    }

}

// end of arash code..

// lets try this
//if(isset($_POST['do_add_skill']) && $_POST['skill-name'] != 'New') {
//    $skillname = $_POST['skill-name'];
//    $skillFormName;
//    $skilllvl = $_POST['skill-lvl'];
//    $skillweight = $_POST['skill-weight'];
//
//    // convert the id back into the skills name
//    foreach($user->tat_get_skills() as $d){
//        if($d['Id'] == $skillname){
//            $skillFormName = $d['Name'];
//        }
//    }
//
//    // save our skills data to display to user
//    $_SESSION['skills'] = "<tr><td></td><td>" . $skillFormName .
//        "</td><td>" . $skilllvl .
//        "</td><td>" . $skillweight .
//        "</td><td></td></tr>";
//
//    $_SESSION['all-skills'][] = $_SESSION['skills'];
//    $_SESSION['insert-skills'][] = $skillname . '/' . $skilllvl . "/" . $skillweight;
//    //var_dump($_SESSION['insert-skills']);
//
//    // create a new inout if the user wants to add a skill
//
//}



//if(isset($_POST['do_add_new_skill'])){
//    $new_skill = $_POST['txt-new-skill-input'];
//    if(empty($_POST['txt-new-skill-input'])){
//        $error = "Please give new skill a name!";
//    }else {
//        // add the new skill
//        $user->tat_add_new_skill($new_skill);
//    }
//
//}

if(isset($_POST['do_create_project'])){





	$skill_id = array();
	if(isset($_POST['req-id'])) {
		foreach ($_POST['req-id'] as $key => $s) {

			$skill_id[] = $s;
		}
		$skill_weights = $_POST['skill-weight'];

		$skill_levels = $_POST['skill-lvl'];


	}

	// get ready the data ready to be sent for inserting
    $formData = array();
    $formData['assoc_course'] = $_POST['txt-select-assoc'];
    $_SESSION['assoc_course_id'] = $_POST['txt-select-assoc'];
    $formData['Title'] = $_POST['txt-project-name'];
    $formData['Type'] = 'Development';
    $formData['Description'] = $_POST['txt-project-description'];
    $formData['Manager_Id'] = '0';
    $formData['Status'] = '';
    $formData['Size_Min'] = $_POST['txt-min-size'];
    $formData['Size_Max'] = $_POST['txt-max-size'];
    $formData['Skill_Id'] = $skill_id;
	$formData['skill-lvl'][] = $skill_levels;
	$formData['skill-weight'][] = $skill_weights;
    //$formData['Project_Id']; // this should automate
//$formData['Skill_Level'] = $_SESSION['all-skills']; loop through all skills and insert them after creating project

    //echo "id = " . $formData['assoc_course'];
    //hold on here goes nothing..
	if(empty($_POST['req-id'])){
		$error = "Please choose required skills by ticking the check boxes.";
	}else if(empty($_POST['txt-project-name']) || $_POST['txt-project-name'] == ''){
        $error = "Please give the project a name!";
    }else if($_POST['txt-select-assoc'] == 0) {
        $error = "Please associate the course with a current course";
    }else if(empty($_POST['txt-min-size'])){
        $error = "Please give the project a minimum size";
    }else if(empty($_POST['txt-max-size'])){
        $error = "Please give the project a maximum size";
    }else if($_POST['txt-min-size'] > $_POST['txt-max-size']){
		$error = "Opps! looks like you entered a bigger minimum team size then your entered maximum team size,
		please ensure that minimum team sizes are smaller than maximum team sizes.";
	}else{
        $user->tat_create_project($formData);
        $success = "The project '" . $formData['Title'] . "' has been successfully created!";

    }
    //header('Location: view-all-projects.php');
    unset($_POST);

}

// debug remove all skill/project based session data


?>
<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Create New Project</h1>
		</div>
	</div><!-- /.row -->
	<div class="row">
		<div class="col-lg-9">
			<form role="form" method="post">
				<div class="row">
					<div class="col-lg-9">
						<div class="form-group">
                            <?php if ( isset( $error ) ) : ?>
                                <div class="alert alert-danger">
                                    <i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                                </div> <?php
                            endif; ?>
                            <?php
                            if ( isset( $success ) ) : ?>
                            <div class="alert alert-success">
                                <i class="glyphicon glyphicon-ok"></i> &nbsp; <?php echo $success; ?>
                            </div><?php
                            endif; ?>
                            <label>Project Name</label>
							<input class="form-control" placeholder="Enter a name for the project" name="txt-project-name" value="<?php if(isset($_POST['txt-project-name'])){echo $_POST['txt-project-name'];} ?>">
						</div>
						<div class="form-group">
							<label>Project Description</label>
							<p class="help-block">Provide a general description of the project for the students.</p>
							<textarea class="form-control" rows="3" name="txt-project-description" ><?php if(isset($_POST['txt-project-description'])){echo $_POST['txt-project-description'];} ?></textarea>
						</div>
						<div class="form-group">
							<label>Associate Course</label>
							<select class="form-control" name="txt-select-assoc">
                                <option value="0">Please Select A Course</option>
                                <?php foreach($user->tat_get_course_data() as $data) {
                                    //echo "<pre>" . var_dump($data) . "</pre>";

								echo "<option value=" . $data[0] . ">" . $data['Code'] . " " . $data['Title']
                                    . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</option>";
                                }?>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-3">
						<div class="form-group">
							<label>Minimum Project Size</label>
							<input class="form-control" name="txt-min-size" value="<?php if(isset($_POST['txt-min-size'])){echo $_POST['txt-min-size'];} ?>">
						</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
							<label>Maximum Project Size</label>
							<input class="form-control" name="txt-max-size" value="<?php if(isset($_POST['txt-max-size'])){echo $_POST['txt-max-size'];} ?>">
						</div>
					</div>
				</div>
				<div class="row">
				</br></br>
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							Required Skills &amp; Competencies
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">

								<table class="table table-hover">
									<thead>
									<tr>
										<th>Required</th>
										<th>Skill Name</th>
										<th>Skill Level</th>
										<th>Weight</th>
<!--										<th>Action</th>-->
									</tr>
									</thead>



										<tbody>
										<?php
										// loop through all skills for all projects assigned to the course instances array
										foreach($user->tat_get_skills() as $cps) { ?>

										<tr>
											<td><input type="checkbox" name="req-id[]" value="<?php echo $cps['Id'] ?>"></td>
												<td><?php echo $cps['Name']; ?></td>
												<td>


													<select class="form-control" name="skill-lvl[]">
														<option value="None">None</option>
														<option value="Beginner">Beginner (1-6 mth)</option>
														<option value="Intermediate">Intermediate (6-12 mth)</option>
														<option value="Advanced">Advanced (1-3 yrs)</option>
														<option value="Expert">Expert (3+ yrs)</option>
													</select>
												</td>
											<td>
												<select class="form-control" name="skill-weight[]">
													<option value="1">1 (Lowest)</option>
													<option value="2">2</option>
													<option value="3">3</option>
													<option value="4">4</option>
													<option value="5">5 (Highest)</option>
												</select>
											</td>
											<?php } ?>
											</tr>
                                        <?php
                                        if(isset($_SESSION['new_skill_added'])) {
                                            echo $_SESSION['new_skill_added'];
                                        } ?>
                                        <button type="submit" class="btn btn-outline btn-primary" name="do_add_skill">Add new skill</button>
										</tbody>

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
			<button type="submit" class="btn btn-outline btn-primary" name="do_create_project">Create Project</button>
		</form>
	</div>
	<!-- /.row (nested) -->
</div><!-- /.page-wrapper -->

