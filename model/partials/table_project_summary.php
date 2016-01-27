<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$('#myTable').DataTable( {
		"columnDefs": [
		{"orderData": [0,3,2], "tagets": 0}
		]
	});
});
</script>

<?php
	
	$sql_courseSumm = 'SELECT 
				tat_course.Code, 
				tat_course.Title, 
				tat_course_instance.Year, 
				tat_course_instance.Study_Period, 
				tat_course_instance.Status, 
				tat_course_instance.Location,
				Lect_Name.First_Name,
				Lect_Name.Last_Name,
				COUNT(tat_course_project.Project_Id) AS Count_Projects, 
				SUM(tat_project.Size_Max) AS Sum_Project_Size, 
				Count_Course_Students.C_cs AS Count_Students,
				Percentage_Complete.C_per AS Perc_Comp,
				tat_course_instance.Projects_Created
			FROM 
				tat_course 
				LEFT JOIN tat_course_instance ON tat_course_instance.Course_Id = tat_course.Id 
				LEFT JOIN tat_course_project ON tat_course_project.Course_Instance_Id = tat_course_instance.Id 
				LEFT JOIN tat_project ON tat_project.Id = tat_course_project.Project_Id 
				LEFT JOIN (
					SELECT tat_course_student.Course_Instance_Id, COUNT(tat_course_student.User_Id) AS C_cs 
					FROM tat_course_student 
					GROUP BY tat_course_student.Course_Instance_Id)Count_Course_Students 
					ON Count_Course_Students.Course_Instance_Id = tat_course_instance.Id 
				LEFT JOIN (
					SELECT tat_course_student.Course_Instance_Id, COUNT(tat_course_student.User_Id) AS C_per 
					FROM tat_course_student 
					WHERE tat_course_student.Skills_Updated = "Yes"
					GROUP BY tat_course_student.Course_Instance_Id) Percentage_Complete 
					ON Percentage_Complete.Course_Instance_Id = tat_course_instance.Id 
				LEFT JOIN (
					SELECT tat_user.Id, tat_user.First_Name, tat_user.Last_Name
					FROM tat_user) Lect_Name
					ON Lect_Name.Id = tat_course_instance.Facilitator
			WHERE
				ISNULL(Lect_Name.Id) LIKE :lectid OR
				Lect_Name.Id LIKE :lectid
			GROUP BY
				tat_course_instance.Id
			ORDER BY 
				tat_course.Code ASC, 
				tat_course_instance.Year ASC, 
				tat_course_instance.Study_Period ASC';
	

	if ($_SESSION['users_type'] == "admin"){
		$Lect_id = "%";  // set to allow visibility against all lecturers
	}
	else {
		$Lect_id = $_SESSION['users_session'];
	}
	
	$q = $DB_con->prepare($sql_courseSumm);
	$q->execute(array(':lectid'=>$Lect_id));
	$q->setFetchMode(PDO::FETCH_ASSOC);

?>
<table id="myTable" class = "table table-striped">
	<thead>
		<tr>
			<th style="width:5%">Course Code</th>
			<th style="width:26%">Course Name</th>
			<th style="width:8%">Semester</th>
			<th style="width:6%">Location</th>
			<th style="width:17%">Lecturer</th>
			<th style="width:7%">Status</th>
			<th style="width:6%"># Projects Created</th>
			<th style="width:6%">Total Spaces</th>
			<th style="width:6%"># Students in Course</th>
			<th style="width:7%">% Skills Completed</th>
			<th style="width:6%">Teams Created</th>
		</tr>
	</thead>
	<tbody>
	
	<?php

	
		while ($rows = $q->fetch()){
			
			$rows['Sum_Project_Size'] = (!isset($rows['Sum_Project_Size']) ? 0 : $rows['Sum_Project_Size']);
			$rows['Count_Students'] = (!isset($rows['Count_Students']) ? 0 : $rows['Count_Students']);
			$rows['Perc_Comp'] = (!isset($rows['Perc_Comp']) ? 0 : $rows['Perc_Comp']);
			$skills_complete = ($rows['Count_Students'] == 0) ? 0 : $rows['Perc_Comp']/$rows['Count_Students']*100;
			$skills_complete_formated = number_format($skills_complete, 2);
			
			echo("<tr>
					<td>$rows[Code]</td>
					<td>$rows[Title]</td>
					<td>$rows[Year] - $rows[Study_Period]</td>
					<td>$rows[Location]</td>
					<td>$rows[First_Name] $rows[Last_Name]</td>
					<td>$rows[Status]</td>
					<td>$rows[Count_Projects]</td>
					<td>$rows[Sum_Project_Size]</td>
					<td>$rows[Count_Students]</td>
					<td>$skills_complete_formated</td>
					<td>$rows[Projects_Created]</td>
				  </tr>");
		}
	?>
	</tbody>
</table>
	
