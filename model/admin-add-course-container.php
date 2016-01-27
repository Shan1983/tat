<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Add New Course</h1>
		</div>
	</div><!-- /.row -->
    
     <?php
    // used to display a message if a course as been successfully added
    if ( isset($_SESSION['course_added']) ) {
        if ($_SESSION['course_added'] == 1) { ?>
            <div class="row">
                <div class="col-lg-12">
                    <div class="alert alert-success">
                        <i class="glyphicon glyphicon-ok"></i> &nbsp; <p>Course added successfully!<p>
                    </div>
                </div>                 <!-- /.col-lg-12 -->
            </div>
    <?php 
        // unset $_SESSION['course_added']
        unset($_SESSION['course_added']);
        } 
    } ?>
    
    <?php 
    // used to display error to user
    // if value is set, show message for adding course errors
    if ( isset( $_SESSION['add_course_error'] ) ) {
        $error = $_SESSION['add_course_error'];
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
    <?php unset( $_SESSION['add_course_error']); 
    } ?> 
    
	<div class="row">
		<div class="col-lg-9">
			<form role="form" method="post" action="controller/add_course.php" >
				<div class="row">
					<div class="col-lg-9">
						<div class="form-group">
							<label>Course Title</label>
							<input type="text" name="course_title" class="form-control"  placeholder="Enter a title for the course" required>
						</div>

                        <div class="form-group">
                            <label>Course Code</label>
                            <input type="text" name="course_code" class="form-control" placeholder="Provide the course code, e.g: CPT110" required>
                        </div>
						<div class="form-group">
							<label>Course Description</label>
							<p class="help-block">Provide a short description of the course for the students.</p>
							<textarea name="course_short_desc" class="form-control" rows="3" required></textarea>
						</div>

						
					</div>
				</div>

			<button type="submit" class="btn btn-outline btn-primary" name="do_add_course">Add Course</button>
		</form>
	</div>
	<!-- /.row (nested) -->
</div><!-- /.page-wrapper -->