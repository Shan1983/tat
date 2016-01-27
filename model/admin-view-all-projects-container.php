<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">All Projects</h1>
		</div>
	</div><!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
            <?php foreach($user->tat_display_all_courses() as $courses) { ?>
			<h4 class="page-header"><?php echo $courses['Code'] . " " . $courses['Title'] . " (" . $courses['Year'] . ") " . " - " . $courses['Study_Period']; ?></h4>


                <div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Project Name</th>
							<th>Team Size</th>
							<th>No. of Skills</th>
							<th>Action</th>
						</tr>
					</thead>
                    <?php foreach($user->tat_display_all_projects() as $projects) {
                        if($projects['Course_Instance_Id'] == $courses['Course_Instance_Id']) {
                        ?>

					<tbody>

						<tr>

							<td><a href="edit-project.php?pid=<?php echo $projects['Project_Id']; ?>"><?php echo $projects['Title']; ?></a></td>
							<td><?php echo "Min: ".$projects['Size_Min'] . ", Max: " . $projects['Size_Max']; ?></td>
							<td><?php echo $user->tat_count_skills($projects['Project_Id']); ?></td>
							<td><a href="edit-project.php?pid=<?php echo $projects['Project_Id']; ?>">Edit</a> | <a href="delete.php?pid=<?php echo $projects['Project_Id']; ?>">Remove</a></td>

						</tr>

					</tbody>
                    <?php } } ?>
				</table>
			</div>
			<!-- /.table-responsive -->
			<form action="create-project.php">
				<input type="hidden" name="cid" value="X">
				<button type="submit" class="btn btn-outline btn-primary">Add Project</button>
			</form>
<br/>
            <?php  }  ?>

		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div><!-- /.page-wrapper -->