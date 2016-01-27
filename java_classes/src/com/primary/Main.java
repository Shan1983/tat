package com.primary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Main
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		final int MAX_MAX_TIME = 500;
		
		// Open a database connection, close at end of main()
		DatabaseConnection db = new DatabaseConnection();
		Data_Utilities ld = new Data_Utilities();
		
		// args required (in orgder): course_code, course_year, study_period,
		// methodology, max_run_time
		// retrieve main args
		if (args.length != 5){
			ExitToWeb.exit_on_unsaveable_error("Incorrect number of arguments passed to java appliction", db);
		}
		else if (!Helper_utilities.isInteger(args[1]) || (Integer.parseInt(args[1]) < 2010) || (Integer.parseInt(args[1]) > 2100)){
			ExitToWeb.exit_on_unsaveable_error("Course year is not an integer", db);
		}
		else if (!Helper_utilities.isInteger(args[4])){
			ExitToWeb.exit_on_unsaveable_error("Max run time is not an integer", db);
		}
		else if (Integer.parseInt(args[4]) > MAX_MAX_TIME){
			ExitToWeb.exit_on_unsaveable_error("Max run time is too long", db);
		}
		
		String course_code = args[0];
   	int course_year = Integer.parseInt(args[1]);
   	String study_period = args[2];
   	String methodology = args[3];
   	double max_run_time = TimeUnit.SECONDS.toMillis((long) Double.parseDouble(args[4]));

		// instantiate and populate courseInstanceIteration object, if error,
		// object will be null
		CourseInstanceIteration ci_iteration = ld.load_course_instance_data(db,
				course_code, course_year, study_period, methodology, max_run_time);

		// check if CourseInstanceObject is null, do something if it is, exit?
		if (ci_iteration == null){
			ExitToWeb.exit_on_finish("Course Instance does not exist", db, ld, ci_iteration);
		}
//		Business decision to be confirmed by Project Manager
//		else if (ci_iteration.getCi_status().equalsIgnoreCase("Approved")){
//			ExitToWeb.exit_on_finish("Coures Instance already has approved teams", db, ld, ci_iteration);
//		}

		// load student data and associated skills to each student object from
		// database
		
		ld.load_student_data(db, ci_iteration);
		
		// test if all students have updated skills
		if (ci_iteration.getCi_status().equalsIgnoreCase("Active_Incomplete")){
			ExitToWeb.exit_on_finish("Not all students have updated skills", db, ld, ci_iteration);
		}
		
		ld.load_student_skills_data(db, ci_iteration.getStudents());

		// load associated project data and project skill requirements into
		// courseInstanceIteration from database
		ld.load_project_data(db, ci_iteration);
		ld.load_project_requirements(db, ci_iteration.getProjects());
		
		
//		TestFunctions.test_print_course_instance(ci_iteration);
//		TestFunctions.test_print_projects(ci_iteration);
//		TestFunctions.test_print_student_details(ci_iteration.getStudents());
//		TestFunctions.test_print_project_team(ci_iteration);

		/*
		 * validate student numbers
		 */
		if (ci_iteration.validate_student_numbers()==false)
		{
			ExitToWeb.exit_on_finish("Ratio of students to projects is not valid", db, ld, ci_iteration);
		}
		// ITERATIVE LOOP STARTS
		
		// run reset_rerun function to remove any potential unique matches for projects in the tat_project_user table
		ld.rerun_reset(db, ci_iteration);

		while ((Calendar.getInstance().getTimeInMillis()
				- ci_iteration.getStart_time()) <= ci_iteration.getMax_run_time())
		{
			ci_iteration.setIteration_count(ci_iteration.getIteration_count() + 1);

			/*
			 * select project methodology to run
			 */

			//System.out.println("1");
			
			if (ci_iteration.getMethodology()
					.equalsIgnoreCase("Project_Focus_Simple"))
			{
				ci_iteration.runProjectFocusSimple();
			}

			/*
			 * calculate balance metrics
			 */
			if (ci_iteration.getOverall_balance() > 0 )
			{
				if (ci_iteration.getOverall_balance()> ci_iteration.getCurrent_overall_balance() )
				{
					// remove all current projects from "fixed list" and replace with those in random list
					ci_iteration.setProjectsEmpty();
					ArrayList<Project> project_list = new ArrayList<Project>();
					
					for (Project p : ci_iteration.getRandom_projects()){

						project_list.add(new Project(p, "to_primary"));
						
					}
					
					ci_iteration.setProjects(project_list);
					ci_iteration.setOverall_balance(ci_iteration.getCurrent_overall_balance());
				}
			}
			else
			{
				// remove all current projects from "fixed list" and replace with those in random list
				ci_iteration.setProjectsEmpty();
				ArrayList<Project> project_list = new ArrayList<Project>();
				
				for (Project p : ci_iteration.getRandom_projects()){

					project_list.add(new Project(p, "to_primary"));
					
				}
				
				ci_iteration.setProjects(project_list);
				ci_iteration.setOverall_balance(ci_iteration.getCurrent_overall_balance());
			}
			
			if (ci_iteration.getOverall_balance()==0)
			{
//				TestFunctions.test_print_course_instance(ci_iteration);
//				TestFunctions.test_print_projects(ci_iteration);
//				TestFunctions.test_print_student_details(ci_iteration.getStudents());
//				TestFunctions.test_print_project_team(ci_iteration);
				
				ci_iteration.setCi_status("Interim");
				ci_iteration.save_data_on_exit(db, ld);
				ExitToWeb.exit_on_finish("Normal_Exit", db, ld, ci_iteration);
			}
		}
		
//		TestFunctions.test_print_course_instance(ci_iteration);
//		TestFunctions.test_print_projects(ci_iteration);
//		TestFunctions.test_print_student_details(ci_iteration.getStudents());
//		TestFunctions.test_print_project_team(ci_iteration);
		

		// ITERATIVE LOOP ENDS

		/*
		 * save data to database focus: this saves the interim results
		 * 
		 * 
		 * notes - will need a separate function for when these results are
		 * approved -- this probably only needs to change the project_team_status
		 * field from interim to approved
		 * 
		 * notes - if any dummy skills have been created, they will need to be
		 * written to the project table first
		 */

		
		/* inserts into tat_project_user
		 * the student id, project id, and the assigned skill id
		 * check that its using the correct course instance for looping through
		 * the student data.
		 */
		ci_iteration.setCi_status("Interim");
		ci_iteration.save_data_on_exit(db, ld);

		/*
		 * exit back to website
		 */
		ExitToWeb.exit_on_finish("Normal_Exit", db, ld, ci_iteration);
		
		// Close database connection		
		db.disconnectDatabase();
	}
}

