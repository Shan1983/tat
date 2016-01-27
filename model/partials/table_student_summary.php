<?php

	if (!isset($_POST['select_course'])){
	}
	else {
		$sql_course = 'SELECT
						tat_course_instance.Id AS ci_id, 
						tat_course_instance.Year, 
						tat_course_instance.Study_Period, 
						tat_course.Code, 
						tat_course.Title
					FROM tat_course_instance
						INNER JOIN tat_course ON tat_course.Id = tat_course_instance.Course_Id
					WHERE tat_course_instance.Id = ?';
		
		$q_c = $DB_con->prepare($sql_course);
		$q_c->execute(array($_POST["select_course"]));
		$q_c->setFetchMode(PDO::FETCH_ASSOC);
		
		$first_row = $q_c->fetch();
		echo("<h4>Course Selected: $first_row[Title] --> $first_row[Year] / $first_row[Study_Period]</h4>");
	}	

?>


<div class="dataTable_wrapper">
	<table class="table table-striped table-bordered table-hover table_fixed" id="dataTables-example">
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Skills Complete</th>
			</tr>
		</thead>
			<tbody>

<?php


	if (!isset($_POST['select_course'])){
	}
	else {
		$sql_students = 'SELECT 
							tat_user.employee_number AS user_id, 
							tat_user.First_Name, 
							tat_user.Last_Name, 
							tat_user.Email, 
							tat_course_student.Skills_Updated
						FROM tat_user
							INNER JOIN tat_course_student ON tat_course_student.User_Id = tat_user.Id
							INNER JOIN tat_course_instance ON tat_course_instance.Id = tat_course_student.Course_Instance_Id
							INNER JOIN tat_course ON tat_course.Id = tat_course_instance.Course_Id
						WHERE
							tat_course_instance.Id = ?';
		
		$q_st = $DB_con->prepare($sql_students);
		$q_st->execute(array($_POST["select_course"]));
		$q_st->setFetchMode(PDO::FETCH_ASSOC);
	
		while ($rows = $q_st->fetch()){
			echo("<tr>
					<td>$rows[user_id]</td>
					<td>$rows[First_Name]</td>
					<td>$rows[Last_Name]</td>
					<td>$rows[Email]</td>
					<td>$rows[Skills_Updated]</td>
				</tr>");
		}
					
		echo("</tbody> </table> </div>");

	}
?>

