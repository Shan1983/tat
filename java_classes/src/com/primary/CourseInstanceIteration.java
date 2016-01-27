package com.primary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/** 
 * Extends the CourseInstance class and adds additional functionality. Is the heart of this program.
 */
public class CourseInstanceIteration extends CourseInstance
{
	private String methodology;
	private double max_run_time;
	private int sum_max_project_students;
	private int sum_min_project_students;
	private int count_students;
	private double start_time; // time counter in milliseconds
	private int iteration_count;
	private ArrayList<Project> random_projects;
	private ArrayList<Student> random_students;
	private double current_overall_balance;

	/**
	 * Constructor for CourseInstanceIteration class
	 * 
	 * @param instance_id
	 *           - integer
	 * @param course_code
	 *           - String
	 * @param course_name
	 *           - String
	 * @param year
	 *           - integer
	 * @param study_period
	 *           - String
	 * @param ci_status
	 *           - String
	 * @param lecturer
	 *           - String
	 * @param methodology
	 *           - String
	 * @param max_run_time
	 *           - double
	 */
	public CourseInstanceIteration(int instance_id, String course_code,
			String course_name, int year, String study_period, String ci_status,
			String lecturer, String methodology, double max_run_time) {
		super(instance_id, course_code, course_name, year, study_period,
				ci_status, lecturer);
		this.iteration_count = 0;
		this.methodology = methodology;
		this.max_run_time = max_run_time;
		this.start_time = Calendar.getInstance().getTimeInMillis();
		random_projects = new ArrayList<Project>();
		random_students = new ArrayList<Student>();
	}

	// Getters and Setters

	/**
	 * Returns the value of this object's methodology attribute.
	 * 
	 * @return String
	 */
	public String getMethodology()
	{
		return methodology;
	}

	/**
	 * Sets the value of this object's methodology attribute to the passed in
	 * parameter.
	 * 
	 * @param methodology
	 *           - String to be set
	 */
	public void setMethodology(String methodology)
	{
		this.methodology = methodology;
	}

	/**
	 * Returns the value of this object's max_run_time attribute.
	 * 
	 * @return double
	 */
	public double getMax_run_time()
	{
		return max_run_time;
	}

	/**
	 * Sets the value of this object's max_run_time attribute to the passed in
	 * parameter.
	 * 
	 * @param max_run_time
	 *           - double to be set
	 */
	public void setMax_run_time(double max_run_time)
	{
		this.max_run_time = max_run_time;
	}

	public int getSum_max_project_students()
	{
		return sum_max_project_students;
	}

	public void setSum_max_project_students(int sum_max_project_students)
	{
		this.sum_max_project_students = sum_max_project_students;
	}

	public int getSum_min_project_students()
	{
		return sum_min_project_students;
	}

	public void setSum_min_project_students(int sum_min_project_students)
	{
		this.sum_min_project_students = sum_min_project_students;
	}

	public int getCount_students()
	{
		return count_students;
	}

	/**
	 * Sets the value of this object's count_students to the passed in parameter.
	 * 
	 * @param count_students
	 *           - integer to be set
	 */
	public void setCount_students(int count_students)
	{
		this.count_students = count_students;
	}

	public double getStart_time()
	{
		return start_time;
	}

	public void setStart_time(double start_time)
	{
		this.start_time = start_time;
	}

	/**
	 * Returns the value of this object's iteration_count attribute.
	 * 
	 * @return integer
	 */
	public int getIteration_count()
	{
		return iteration_count;
	}

	/**
	 * Sets the value of this object's iteration_count attribute to the passed in
	 * parameter.
	 * 
	 * @param iteration_count
	 *           - integer to be set
	 */
	public void setIteration_count(int iteration_count)
	{
		this.iteration_count = iteration_count;
	}

	/**
	 * Returns the values of this objects random_projects ArrayList collection.
	 * 
	 * @return ArrayList of Project objects
	 */
	public ArrayList<Project> getRandom_projects()
	{
		return random_projects;
	}

	/**
	 * Sets this objects random_projects ArrayList as the passed in parameter.
	 * 
	 * @param random_projects
	 *           - ArrayList of Project objects
	 */
	public void setRandom_projects(ArrayList<Project> random_projects)
	{
		this.random_projects = random_projects;
	}

	/**
	 * Returns the values of this objects random_studentss ArrayList collection.
	 * 
	 * @return ArrayList of Student objects
	 */
	public ArrayList<Student> getRandom_students()
	{
		return random_students;
	}

	/**
	 * Sets this objects random_student ArrayList as the passed in parameter.
	 * 
	 * @param random_students
	 *           - ArrayList of Student objects
	 */
	public void setRandom_students(ArrayList<Student> random_students)
	{
		this.random_students = random_students;
	}

	/**
	 * Returns the value of this object's current_overall_balance attribute.
	 * 
	 * @return double
	 */
	public double getCurrent_overall_balance()
	{
		return current_overall_balance;
	}

	/**
	 * Sets the value of this object's current_overall_balance attribute as the
	 * passed in parameter.
	 * 
	 * @param current_overall_balance
	 *           - double to be as
	 */
	public void setCurrent_overall_balance(double current_overall_balance)
	{
		this.current_overall_balance = current_overall_balance;
	}

	// allocation methodologies

	/**
	 * Evaluates teams for given projects of a course instance object based on
	 * required project skills and students skills.
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public void runProjectFocusSimple()
	{
		/*
		 * create random lists: students and projects
		 */

		random_projects.clear();
		random_students.clear();

		for (Project p : this.getProjects())
		{
         // remove any previously assigned team members within the random_projects
         // (because when copying the data on subsequent iterations, will also copy
         // the previously assigned team member structure)
         // this is managed within the copy constructor by the control variable

			random_projects.add(new Project(p, "to_random"));
			
		}

		for (Student s : this.getStudents())
		{
			random_students.add(new Student(s));
		}

		// // NOTE: if we combine the ProjectTeamMember class into Student class
		// will
		// // need to reset the assigned skill id

		// randomly shuffle random_projects and random_students
		Collections.shuffle(this.random_projects);
		Collections.shuffle(this.random_students);

		// Instantiate working_skills_list
		ArrayList<ProjectSkill> working_skill_list = null;

		/*
		 * Cycle 1A allocate students to teams focus: up to minimum team numbers
		 */

		for (Project rp : random_projects)
		{ // get next project from random project list -->
		  // this will ensure that all projects have teams allocated
			Boolean control_1 = true;
			Boolean control_2 = true;

			while ((rp.getCurrent_team_size() < rp.getMin_size())
					&& (!rp.getIncomplete_status()))
			{
				// current_team_size < min_team_size AND project not marked as
				// incomplete
				// --> this will ensure that all teams either
				// reach the minimum team size OR are marked incomplete before
				// moving to next project
				// incomplete_status is set as false when a project is initialised

				// function: sum weightings of unassigned project skills --> if
				// sum = 0 (ie no unassigned skills exist), set CONTROL_1 to false
				if (rp.calculate_unassigned_skills_weightings() == 0)
				{
					control_1 = false;
				}

				if (control_1)
				{ // use CONTROL_1: a test to see if unassigned skills exist in
				  // project

					if (control_2)
					{ // use CONTROL_2: a test to see if all
					  // skills in previously created list have
					  // been finished, default is true
					  // function: identify highest skill weighting using
					  // modified skill weighting in project yet unassigned
						int highest_weighting = rp.get_highest_skill_weighting();
						// function: create list of all skills with the same
						// highest modified skill weighting -->
						working_skill_list = rp
								.skills_based_on_weighting(highest_weighting);
						// working_skill_list
						// function: randomly order working_skill_list
						Collections.shuffle(working_skill_list);
						control_2 = false;
					}

					// function: select next project skill from
					// working_skill_list
					ProjectSkill skill = working_skill_list.get(0);

					// function: identify student that matches modified skill
					// weighting
					Student student = this.match_student_to_skill(skill);

					if (student != null) // if student is not null, match found
					{ // student found
					  // function: assign student to project --> create
					  // ProjectTeamMember and add to
					  // random_projects.project_team_members
						this.assign_student_to_project(student, skill, rp);

						// function: remove student from random_student_list
						this.remove_object_from_list(student, random_students);

						// function: remove project skill from working_skill_list
						this.remove_object_from_list(skill, working_skill_list);

						skill.set_modified(false);

						// reset control_2 to true iff work_skill_list is empty
						if (working_skill_list.isEmpty())
						{
							control_2 = true;
						}
					} else
					{ // student not found

						if (skill.is_modified() == false
								&& skill.getModified_weighting() != 0)
						{ // modified skill weighting adjustment not
						  // already occurred && skill weighting != 0
						  // function: adjust modified skill weighting for
						  // skill --> reduce by 1
						  // function: record modified skill weighting
						  // occurrence
							this.modify_skill_weighting(skill);
						} else
						{ // modified skill weighting previously occurred
						  // function: remove project skill from working_skill_list
							this.remove_object_from_list(skill, working_skill_list);
							skill.set_modified(false);

							if (working_skill_list.isEmpty())
							{ // count of working_skill_list == 0
								control_2 = true;
							}
						}
					}
				} else
				{
					rp.setIncomplete_status(true);
				}
			}
		}

		/*
		 * Cycle 1B allocate students to teams focus: dealing with any projects
		 * that did not reach minimum team size and where therefore marked
		 * incomplete
		 */

		for (Project rp : random_projects)
		{ // get next project from random project list
		  // don't think need incomplete project status for this cycle
			while (rp.getCurrent_team_size() < rp.getMin_size())
			{ // current_team_size < min_team_size
				if (!rp.check_unassigned_skills())
				{ // does an unallocated project skill exist
				  // function: create dummy project skill with weighting 0
				  // dummy skill id?? being set as a default 0 in constructor
					ProjectSkill dummy = new ProjectSkill("Dummy", 0);
					rp.add_project_skill(dummy);
					// note: probably need to save this dummy skill into the
					// database as part of the save activities
					// possibly also need to have this set up in the skill table as a
					// default
				}

				// function: get a random skill with no allocated student
				ProjectSkill skill = rp.get_unallocated_skill();

				// function: get first student from random student list
				Student student = this.random_students.get(0);

				// function: assign student to project - against skill or dummy
				// skill (duplicate)
				this.assign_student_to_project(student, skill, rp);
				// function: remove student from random_student_list (duplicate)
				this.remove_object_from_list(student, random_students);
			}
		}

		/*
		 * Cycle 2 allocate students to teams focus: allocate remaining students
		 * to teams ensuring no team goes over maximum team number
		 */

		while (random_students.size() != 0)
		{

			for (Project rp : random_projects)
			{ // get next project from random project list
			  // this is an if not a while because want each project to get an
			  // additional student, before add a second additional
			  // student to any project

				if ((rp.getCurrent_team_size() < rp.getMax_size())
						&& random_students.size() != 0)
				{ // need to test students remain available to assign
					if (!rp.check_unassigned_skills())
					{ // does an unallocated project skill exist
					  // function: create dummy project skill with weighting 0
						ProjectSkill dummy = new ProjectSkill("Dummy", 0);
						rp.add_project_skill(dummy);
						// note: probably need to save this dummy skill into the
						// database as part of the save activities
					}

					// function: get a random skill with no allocated student
					// (maybe returning the dummy skill)
					ProjectSkill skill = rp.get_unallocated_skill();

					// identify student that matches skill name (can ignore
					// weighting)
					Student student = this.match_student_skill_nameOnly(skill);

					if (student == null)
					{ // if student is null,
					  // student not found
					  // function: get first student from random student list
					  // (duplicate)'
						student = this.random_students.get(0);
					}

					// function: assign student to project - against skill or
					// dummy skill (duplicate)
					this.assign_student_to_project(student, skill, rp);
					// function: remove student from random_student_list
					// (duplicate)
					this.remove_object_from_list(student, random_students);
					// function: increment current team size (duplicate)
				}
			}
		}

		setCurrent_overall_balance(calculate_current_overall_balance());
	}

	/// Calculate current_overall_balance
	private double calculate_current_overall_balance()
	{
		double[] data = new double[random_projects.size()];
		for (int i = 0; i < random_projects.size(); i++)
		{
			data[i] = random_projects.get(i)
					.calculate_project_team_distance_sum_difference();
			// data[i] =
			// random_projects.get(i).calculate_project_team_distance_sum_minus_sum();
		}
		Statistics stats = new Statistics(data);
		return stats.getStdDev();
	}

	/**
	 * Generic function which removes the given object T from the given ArrayList
	 * of T objects.
	 * 
	 * @param object
	 *           - T object
	 * @param list
	 *           - ArrayList of T objects
	 * @param <T>
	 *           - generic object
	 */
	public <T> void remove_object_from_list(T object, ArrayList<T> list)
	{
		int index = list.indexOf(object);
		if (index != -1)
		{
			// arrays automatically resize after removal using index
			list.remove(index);
		}
	}

	/**
	 * Matches a student to a required skill by iterating through given
	 * random_students ArrayList. The selected student object in turn has its
	 * ArrayList of skills iterated through and each skill in the student objects
	 * list is compared to the passed in ProjectSkill object parameter comparing
	 * name and weighting.
	 * 
	 * @param skill
	 *           - ProjectSkill object
	 * @return Student object, or null
	 */
	public Student match_student_to_skill(ProjectSkill skill)
	{
		for (Student student : this.random_students)
		{
			for (Skill student_skill : student.get_skills())
			{
				// compare skill names and skill weighting of both objects
				if (student_skill.get_name().equals(skill.get_name())
						&& student_skill.get_weighting() == skill
								.getModified_weighting())
				{
					// if found return student object
					return student;
				}
			}
		}
		return null;
	}

	/**
	 * This function is the same as match_student_to_skill(ProjectSkill skill){}
	 * function, but matches the student skill to the project required skill by
	 * skill name only.
	 * 
	 * @param skill
	 *           - given ProjectSkill object
	 * @return - returns Student object or null
	 */
	public Student match_student_skill_nameOnly(ProjectSkill skill)
	{
		for (Student student : this.random_students)
		{
			for (Skill st_skill : student.get_skills())
			{
				if (st_skill.get_name().equals(skill.get_name()))
				{
					return student;
				}
			}
		}
		return null;
	}

	/**
	 * Modifies the skill weighting of given ProjectSkill object.
	 * 
	 * @param skill
	 *           - ProjectSkill object
	 */
	public void modify_skill_weighting(ProjectSkill skill)
	{
		// ensure to set modified_weighting and modified boolean
		skill.setModified_weighting(skill.getModified_weighting() - 1);
		skill.set_modified(true);
	}

	/**
	 * Assigned given Student object the given ProjectSkill for the given Project
	 * by creating a new ProjectTeamMember object and adding it to the given
	 * project project_team_member list. Sets skill as assigned
	 * 
	 * @param student
	 *           - Student object to be added
	 * @param skill
	 *           - Skill object to be added
	 * @param project
	 *           - Project object to be modified
	 */
	public void assign_student_to_project(Student student, ProjectSkill skill,
			Project project)
	{
		ProjectTeamMember ptm = new ProjectTeamMember(student, skill.get_id());

		project.add_single_team_member(ptm);

		skill.setAssigned(true);
	}

	/**
	 * Validates student count for the require project totals. Returns false of
	 * the number of students is less than the total of the minimum required
	 * number, or if the total is greater than the total of the maximum required
	 * number.
	 * 
	 * @return a boolean value
	 */
	public boolean validate_student_numbers()
	{
		if (count_students < sum_min_project_students)
		{
			return false;
		} else if (count_students > sum_max_project_students)
		{
			return false;
		} else
		{
			return true;
		}

	}

	/**
	 * Save Data to database prior to exiting program
	 * 
	 * Data to save from each class includes: - Course Instance : projects
	 * ArrayList, ci_status, overall_balance - Course Instance Iteration :
	 * methodology, iteration_count - Project : project_team_members ArrayList,
	 * current_project_team_distance - Project Team Members : user_id,
	 * project_id, assigned_skill_id
	 * 
	 * In addition, need to update the app_status with the correct exit type this
	 * occurs in ExitToWeb
	 * 
	 * and save yes to projects_created
	 * 
	 * Also, possibly need to save dummy skills into database where required NOT
	 * DONE
	 *
	 * Class.Field DatabaseTable.Field
	 * ==================================================================
	 * course_instance.ci_status = tat_course_instance.status
	 * course_instance.overall_balance = tat_course_instance.overall_balance
	 * course_instance_iteration.methodology = tat_course_instance.methodology
	 * course_instance_iteration.iteration_count = ???????
	 * project.current_project_team_distance = tat_project.project_difference
	 * project_team.user_id = tat_project_user.user_id project_team.project_id =
	 * tat_project_user.project_id project_team.assigned_skill_id =
	 * tat_project_user.assigned_skill_id
	 * 
	 * @param db
	 *           - database connection
	 * @param ld
	 *           - Data_Utilities object
	 * 
	 */
	public void save_data_on_exit(DatabaseConnection db, Data_Utilities ld)
	{

		// save data to tat_course_instance database table

		String sql1 = "UPDATE tat_course_instance SET " + "status = " + "'"
				+ getCi_status() + "', " + "overall_balance = " + "'"
				+ getOverall_balance() + "', " + "methodology = " + "'"
				+ methodology + "', " + "Projects_Created = 'Yes' " + "WHERE Id = "
				+ getInstance_id();

		ld.saveData(db, sql1);

		for (Project p : getProjects())
		{

			// save data to tat_project

			String sql2 = "UPDATE tat_project SET " + "project_difference = " + "'"
					+ p.getCurrent_project_team_distance() + "'" + "WHERE Id = "
					+ p.getProject_id();
			ld.saveData(db, sql2);

			// save data to tat_project_user

			for (ProjectTeamMember ptm : p.getProject_team_members())
			{

				String sql3 = "REPLACE INTO tat_project_user "
						+ "(User_Id, Project_Id, assigned_skill_id) VALUES (" + "'"
						+ ptm.get_id() + "', " + "'" + p.getProject_id() + "', " + "'"
						+ ptm.getAssigned_skill_id() + "'" + ")";

				ld.saveData(db, sql3);
			}
		}
	}
}