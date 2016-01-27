<?php
// get the course instance id
$cid = $_GET['cid'];

// check if approve allocation button was submitted
if(isset($_POST['do_approve_allocation'])) {
    // check to make sure course instance id exists
    if (empty($cid) || $cid == '') {
        $error = "You must specify a <b>Course Instance ID</b> when approving an allocation.";
    } else {
    	// update the status of the course instance in the database
    	$user->tat_update_team_status($cid, "Approved");
    	$success = "Team allocation is marked as approved.";
		// based on the business rules, yet to be determined we could hide
		// or disable the approve button here too
    }
}

// check if the unapprove allocation button was submitted
// may not be required, pending on project sponsor feedback
if(isset($_POST['do_unapprove_allocation'])) {
    // check to make sure course instance id exists
    if (empty($cid) || $cid == '') {
        $error = "You must specify a <b>Course Instance ID</b> when unapproving an allocation.";
    } else {
    	// update the status of the course instance in the database
    	$user->tat_update_team_status($cid, "Interim");
    	$success = "Team allocation is marked as unapproved.";
    }
}
?>
<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Allocated Teams for</h1>
			<?php
			// used to display error messages
			if ( isset( $error ) ) : ?>
				<div class="alert alert-danger">
                	<i class="glyphicon glyphicon-warning-sign"></i> &nbsp; <?php echo $error; ?>
                </div>
            <?php
            endif;

            // used to display success messages
            if ( isset( $success ) ) : ?>
                <div class="alert alert-success">
                	<strong>Success!</strong> <?php echo $success; ?>
                </div>
			<?php
			endif;

			// loop through all course instanes
			foreach($user->tat_get_course_data() as $data) {
				// only display info of the current course instance
				if ($data[0] == $cid) {
					// display the course instance in the heading
					$balance_format = number_format($data['overall_balance'], 4);
					echo "<h3>" . $data['Code'] . " " . $data['Title'] . " " . "(" . $data['Year'] . ")" . " - " . $data['Study_Period']. "</h3>";
					// display the diffwerence from ideal info, may be replaced with a bar for future releases
					echo "Overall Difference from Ideal: " . $balance_format . "<br/><br/>";

					// determine whether to display approve or unapprove button
					if ($data['Status'] != "Approved") { ?>
						<form role="form" method="post" >
							<button type="submit" class="btn btn-outline btn-primary" name="do_approve_allocation">Approve Allocations</button>
						</form>
					<?php
					} else {  ?>
						<!--
		                <div class="alert alert-info">
		                	This team allocation has been approved and finalised.
		                </div>
		                -->
						<form role="form" method="post" >
							<button type="submit" class="btn btn-outline btn-primary" name="do_unapprove_allocation">Unapprove Allocations</button>
						</form>
					<?php
					}
				}
			}?>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-10">
			<?php
			// set base index value, which is used for the team numbering
			$index = 1;
			// loop through all projects
			foreach($user->tat_display_all_projects() as $projects) {
				// select only projects assigned to this course instance
                if ($projects['Course_Instance_Id'] == $cid) {?>
			<h4 class="page-header">Team #<?php echo $index; ?>: <?php echo $projects['Title']; ?></h4>
			<div class="row">
				<div class="col-lg-8">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th width="50%">Student Name</th>
									<th width="50%">Matching Skill</th>
								</tr>
							</thead>
							<tbody>
							<?php
							// loop through all the students and matched skill allocated to the project
							foreach($user->tat_fetch_project_students($projects['Project_Id']) as $students) {  ?>
								<tr>
									<td><?php echo $students['First_Name'] . " " . $students['Last_Name'] . " (" . $students['employee_number'] . ")"; ?></td>
									<td>
									<?php 
									if ($students['Skill_Name'] == "") {
										echo "None";
									} else {
										echo $students['Skill_Name'];
									} ?>
									</td>
								</tr>
							<?php  } ?>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<div class="col-lg-4">
					<?php
						// calculated project difference and colour of progress bar
						$project_diff = $user->tat_calc_project_difference($projects['Project_Id']);

						if ($project_diff > 0 && $project_diff <=20) {
							$project_bar = "progress-bar-danger";
						} else if ($project_diff > 20 && $project_diff <= 40) {
							$project_bar = "progress-bar-warning";
						} else if ($project_diff > 40 && $project_diff <= 60) {
							$project_bar = "progress-bar-info";
						} else if ($project_diff > 60 && $project_diff <= 80) {
							$project_bar = "";
						} else if ($project_diff > 80 && $project_diff <= 100) {
							$project_bar = "progress-bar-success";
						}
					?>
					<p>Difference from Ideal: <?php echo $project_diff; ?></p>
					<!--
					<div class="progress">
						<div class="progress-bar <?php echo $project_bar; ?>" role="progressbar" aria-valuenow="<?php echo $project_diff; ?>" aria-valuemin="0" aria-valuemax="100" style="width: <?php echo $project_diff; ?>%"></div>
					</div>
					-->
					<p>Allocated student(s): <?php echo $user->tat_count_allocated_students($projects['Project_Id']); ?></p>
					<p>Project size: <?php echo $projects['Size_Min'] . " - " . $projects['Size_Max']; ?></p>
					<p>Project skill(s): <?php echo $user->tat_count_skills($projects['Project_Id']); ?></p>
				</div>
			</div>
			<?php 
					$index++;
				}
			 } ?>
		</div>
		<!-- /.col-lg-10 -->
	</div>
	<!-- /.row -->
</div>
<!-- /.page-wrapper -->