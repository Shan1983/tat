<?php
require_once('class_course.php'); ?>

<div class="table-responsive">
  <table class="table table-striped"> 
  	<thead>
      <tr>
        <th>Code</th>
        <th>Title</th>
        <th>Short Description</th>
        <th>Action</th>
      </tr>
    </thead><?php

		// Instantiate the Course class
		$courses = new Course();
		$courses->view_courses( $DB_con ); ?>

	</table>
</div>