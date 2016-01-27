<div id="page-wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h1 class="page-header">Add New Course Instance</h1>
		</div>
	</div><!-- /.row -->
    
     <?php
    // used to display a message if a course instance has been successfully added
    if ( isset($_SESSION['course_instance_added']) ) {
        if ($_SESSION['course_instance_added'] == 1) { ?>
            <div class="row">
                <div class="col-lg-12">
                    <div class="alert alert-success">
                        <i class="glyphicon glyphicon-ok"></i> &nbsp; <p>Course Instance added successfully!<p>
                    </div>
                </div>                 <!-- /.col-lg-12 -->
            </div>
    <?php 
        // unset $_SESSION['course_instance_added']
        unset($_SESSION['course_instance_added']);
        } 
    } ?>
    
    <?php 
    // used to display error to user
    // if value is set, show message for adding course errors
    if ( isset( $_SESSION['add_course_instance_error'] ) ) {
        $error = $_SESSION['add_course_instance_error'];
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
    <?php unset( $_SESSION['add_course_instance_error']);
    } ?> 
    
	<div class="row">
		<div class="col-lg-9">
			<form role="form" method="post" action="controller/add_course_instance.php" >
				<div class="row">
					<div class="col-lg-9">
                    
						<div class="form-group">
							<label for="course_selection">Select Course</label>
                            <select name="course_selection" id="course_selection" class="form-control" required>
                                <option name="course_selection" value=""></option>
                                <?php
                                // read course data from database tat_course table
                                $query = "SELECT * FROM `tat_course`";
                                $statement = $DB_con -> prepare($query);
                                $statement -> execute();
                                
                                while( $row = $statement -> fetch() )
                                {
                                echo "<option name='course_selection' value='" . $row['Id'] . "'>" . $row['Code'] . " - " . $row['Title'] . "</option>";
                                }
                                
                                ?>
                            </select>
						</div>

                        <div class="form-group">
                            <label for="course_facilitator">Select Facilitator</label>
                            <select name="course_facilitator" id="course_facilitator" class="form-control" required>
                                <option name="course_selection" value=""></option>
                                <?php
                                // read lecturer data from database tat_user table
                                $query = "SELECT * FROM `tat_user` WHERE `access_level` = 'lecturer'";
                                $statement = $DB_con -> prepare($query);
                                $statement -> execute();
                                
                                while( $row = $statement -> fetch() )
                                {
                                echo "<option name='course_selection' value='" . $row['Id'] . "'>" . $row['First_Name'] . " " . $row['Last_Name'] . " - " . $row['Email'] . "</option>";
                                }
                                
                                ?>
                            </select>
                        </div>
                        
						
						
					</div>
				</div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="delivery_method">Select course delivery method:</label>
                            <select name="delivery_method" id="delivery_method" class="form-control" required>
                                <option name="delivery_method" value=""></option>
                                <option name="delivery_method" value="OnCampus">On Campus</option>
                                <option name="delivery_method" value="Online">Online</option>
                            </select>
                        </div>
                    </div>
                
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="course_year">Select course year:</label>
                            <select name="course_year" id="course_year" class="form-control" required>
                                <option name="course_year" value=""></option>
                                <option name="course_year" value="2015">2015</option>
                                <option name="course_year" value="2016">2016</option>
                                <option name="course_year" value="2017">2017</option>
                                <option name="course_year" value="2018">2018</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="col-lg-3">
                        <div class="form-group">
                            <label for="course_study_period">Select study period/semester:</label>
                            <select name="course_study_period" id="course_study_period" class="form-control" required>
                                <option name="course_study_period" value=""></option>
                                <option name="course_study_period" value="SP1">SP1</option>
                                <option name="course_study_period" value="SP2">SP2</option>
                                <option name="course_study_period" value="SP3">SP3</option>
                                <option name="course_study_period" value="SP4">SP4</option>
                                <option name="course_study_period" value="Sem1">Semester 1</option>
                                <option name="course_study_period" value="Sem2">Semester 2</option>
                            </select>
                        </div>
                    </div>
                </div>

			<button type="submit" name="do_add_instance" class="btn btn-outline btn-primary">Add Course Instance</button>
		</form>
	</div>
	<!-- /.row (nested) -->
</div><!-- /.page-wrapper -->