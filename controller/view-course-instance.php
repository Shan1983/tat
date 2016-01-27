<?php
require_once('class_course_instance.php'); ?>

<div class="table-responsive">
  <table class="table table-striped"> 
  	<thead>
      <tr>
        <th>Course Code</th>
        <th>Course Title</th>
        <th>Year</th>
        <th>Study Period</th>
        <th>Status</th>
        <th>Facilitator</th>
        <th>Projects Created</th>
        <th>Location</th>
<!--         <th>Action</th> -->
      </tr>
    </thead><?php

	// Instantiate the CourseInstance class
	$courseInstance = new CourseInstance();
	$courseInstance->view_course_instance( $DB_con ); ?>

	</table>
</div>