<div id="page-wrapper">
	<div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Academic Home Page</h1>
        </div>                 <!-- /.col-lg-12 -->
    </div>
	
	<div class="panel panel-default col-1g-12">
		<div class="panel-heading">
			<i>Project Summary for Active Courses</i>
		</div>  				<!-- /.panel-heading -->
				
		<div class="panel-body">
			<div class="row">
				<div class="col-lg-12">
					<?php require_once 'partials/table_project_summary.php' ?>
				</div>			<!-- /.col-lg-12 (nested) -->
			</div> 				<!-- /.row -->
		</div>					<!-- /.panel-body -->
	</div>						<!-- /.panel -->
			
			
	<div class="panel panel-default col-1g-12">
		<div class="panel-heading">
			<i>List of Students in Course</i>
			<div class="pull-right">

				<?php
					$sql_ActiveCourses = 'SELECT 
											tat_course_instance.Id, 
											tat_course_instance.Year, 
											tat_course_instance.Study_Period, 
											tat_course.Code, 
											tat_course.Title
										FROM tat_course_instance
											INNER JOIN tat_course ON tat_course.Id = tat_course_instance.Course_Id
										WHERE 
											tat_course_instance.Status = "active" AND
											tat_course_instance.Facilitator LIKE :lectid';
										
					// also need to limit pull-down list to only those course-instances with the same lecturer as signed in - or all for admin
					if ($_SESSION['users_type'] == "admin"){
						$Lect_id = "%";  // set to allow visibility against all lecturers
					}
					else {
						$Lect_id = $_SESSION['users_session'];
					}
					
					$q_ac = $DB_con->prepare($sql_ActiveCourses);
					$q_ac->execute(array(':lectid'=>$Lect_id));
					$q_ac->setFetchMode(PDO::FETCH_ASSOC);
				?>	
				
				<form id="active_course_list" action="" method = "POST">
					<select id = "select_course" name = "select_course" onchange="document.getElementById('active_course_list').submit();">
						<option selected disabled>Select Course</option>
							<?php
							while ($rows = $q_ac->fetch()){
								echo("<option value=$rows[Id]>$rows[Code] - $rows[Year] - $rows[Study_Period]</option>");
							}
							?>
					</select>
				</form>
			</div>
		</div>
				
		 <div class="panel-body">
		 
			
			<?php 
			require_once 'partials/table_student_summary.php' 
			?>
			<!-- add student table -->
		 
		</div>
	</div>

</div>

</div><!-- /.page-wrapper -->