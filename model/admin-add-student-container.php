<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Add Student</h1>
		</div>
	</div><!-- /.row -->
	<div class="row">
		<div class="col-lg-9">
			<form role="form" method="post">
				<div class="row">
					<div class="col-lg-6">
						<div class="form-group">
                            <label>Student ID</label>
							<input class="form-control" placeholder="Enter student ID" name="txt-student-id" value="">
						</div>
						<div class="form-group">
                            <label>Student First Name</label>
							<input class="form-control" placeholder="Enter student first name" name="txt-student-fname" value="">
						</div>
						<div class="form-group">
                            <label>Student Last Name</label>
							<input class="form-control" placeholder="Enter student last name" name="txt-student-lname" value="">
						</div>
						<div class="form-group">
                            <label>Student Email Address</label>
							<input class="form-control" placeholder="Enter student email address" name="txt-student-email" value="">
						</div>
					</div>
					<div class="col-lg-10">
						<div class="form-group">
							<label>Associate Course(s)</label>
							<p>CPT110 Introduction to Information Technology (2015) - SP3</p>
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
											<th>Skill Name</th>
											<th>Skill Level</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<select class="form-control" name="skill-name">
                                                    <option value="0">Please Select Skill</option>
													<option value="New">**Add New Skill**</option>
												</select>
											</td>
											<td>
												<select class="form-control" name="skill-lvl">
													<option>None</option>
													<option value="Beginner">Beginner (1-6 mth)</option>
													<option value="Intermediate">Intermediate (6-12 mth)</option>
													<option value="Advanced">Advanced (1-3 yrs)</option>
													<option value="Expert">Expert (3+ yrs)</option>
												</select>
											</td>
											<td><button type="submit" class="btn btn-default" name="do_add_skill">Add Skill</button></td>
                                        </tr>
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
			<button type="submit" class="btn btn-outline btn-primary" name="do_create_project">Update Profile</button>
		</form>
	</div>
	<!-- /.row (nested) -->
</div><!-- /.page-wrapper -->