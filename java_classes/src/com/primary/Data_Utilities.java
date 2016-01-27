package com.primary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class used to load data from database tables into corresponding objects of
 * this Java program.
 */
public class Data_Utilities
{

	public Data_Utilities() {

	}

	/**
	 * Loads data into CourseInstanceIteration Object from the database based on
	 * passed in parameters. db is the required database connection. course_code,
	 * course_year, study_period is required to find the specified course
	 * instance to be fetched from the database. Methodology specifies what type
	 * of allocation/balance algorithm to run, and max run time specifies the
	 * maxi_time the algorithm should run for. The function will return a
	 * CourseInstanceObject or a null value.
	 * 
	 * @param db
	 *           - database connection
	 * @param course_code
	 *           - String to match
	 * @param course_year
	 *           - integer to match
	 * @param study_period
	 *           - String to match
	 * @param methodology
	 *           - integer to match
	 * @param max_run_time
	 *           - double for count-down
	 * @return CourseInstanceIteration object, or null
	 */
	public CourseInstanceIteration load_course_instance_data(
			DatabaseConnection db, String course_code, int course_year,
			String study_period, String methodology, double max_run_time)
	{
		Statement statement;
		CourseInstanceIteration ci_iteration = null;

		try
		{
			statement = db.connect().createStatement();
			ResultSet results = statement.executeQuery(
					"SELECT tat_course_instance.Id, tat_course_instance.Course_Id, tat_course_instance.Status,"
							+ " tat_course_instance.Facilitator, tat_course.Title "
							+ "FROM tat_course INNER JOIN tat_course_instance "
							+ "ON tat_course.Id = tat_course_instance.Course_Id "
							+ "WHERE tat_course.Code = '" + course_code + "'"
							+ " AND tat_course_instance.Year = " + course_year
							+ " AND tat_course_instance.Study_Period = '"
							+ study_period + "'");

			if (results.next())
			{ // check if has results
				int id = results.getInt("Id");
				// int course_id = results.getInt("Course_Id");
				String course_name = results.getString("Title");
				// int year = results.getInt("year");
				// String study_period = results.getString("Study_Period");
				String status = results.getString("Status");
				String lecturer = results.getString("Facilitator");

				// construct object with data
				ci_iteration = new CourseInstanceIteration(id, course_code,
						course_name, course_year, study_period, status, lecturer,
						methodology, max_run_time);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
			Helper_utilities.print_error_message(e);
		}
		return ci_iteration;
	}

	/**
	 * Takes in database connection and CourseInstanceIteration object. Fetches
	 * all student user data related to particular CourseInstance from database
	 * and creates Student objects which are stored in CourseInstanceIteration
	 * objects student ArrayList.
	 * 
	 * @param db
	 *           - database connection
	 * @param ci_iteration
	 *           - CourseInstanceIteration object
	 * 
	 */
	public void load_student_data(DatabaseConnection db,
			CourseInstanceIteration ci_iteration)
	{

		Statement stmt;
		// Initialize arrayList
		ArrayList<Student> student_list = new ArrayList<Student>();
		try
		{
			stmt = db.connect().createStatement();
			ResultSet result = stmt.executeQuery(
					"SELECT tat_user.Id, tat_user.First_Name, tat_user.Last_Name, tat_user.email, tat_course_student.Skills_Updated "
							+ "FROM tat_user " + "INNER JOIN tat_course_student ON "
							+ "tat_course_student.User_Id = tat_user.Id "
							+ "INNER JOIN tat_course_instance ON "
							+ "tat_course_instance.Id = tat_course_student.Course_Instance_Id "
							+ "WHERE tat_course_instance.Id = "
							+ ci_iteration.getInstance_id());

			// iterate through results building Student object and storing in
			// students array list
			while (result.next())
			{
				int id = result.getInt("Id");
				String first_name = result.getString("First_Name");
				String last_name = result.getString("Last_Name");
				String email = result.getString("email");
				String skills_updated = result.getString("Skills_Updated");

				// addStudent function is a courseInstance function to load
				// students into the course_instance object
				student_list.add(new Student(id, first_name, last_name, email,
						skills_updated));
			}

			// test if all students have updated their skill lists
			// assume all students have completed updated
			String student_status = "Yes";
			for (Student s : student_list)
			{
				if (s.get_Skills_Updated().equalsIgnoreCase("No"))
				{
					student_status = "No";
				}
			}
			if (student_status.equalsIgnoreCase("No"))
			{
				ci_iteration.setCi_status("Active_Incomplete");
			} else if (student_status.equalsIgnoreCase("Yes"))
			{
				ci_iteration.setCi_status("Active_Complete");
			}

			// ci_iteration.addStudent_to_CourseInstance(student);
			ci_iteration.setStudents(student_list);

			// set the variable count_students
			ci_iteration.setCount_students(student_list.size());

		} catch (SQLException e)
		{
			e.printStackTrace();
			Helper_utilities.print_error_message(e);
		}
	}

	/**
	 * load_student_skils_data iterates through students ArrayList and using
	 * student ID looks for any associated skills inside the tat_user_skill, then
	 * fetches details of each skill based on those results, creates a
	 * corresponding Skill object, and saves it to the corresponding student
	 * object's skills ArrayList.
	 * 
	 * @param db
	 *           - database connection
	 * @param students
	 *           - ArrayList of Student objects
	 */
	public void load_student_skills_data(DatabaseConnection db,
			ArrayList<Student> students)
	{
		Statement statement;

		// iterate through entire student ArrayList
		for (Student student : students)
		{
			// Initialize empty ArrayList
			ArrayList<Skill> skill_list = new ArrayList<Skill>();

			int user_id = student.get_id();
			try
			{
				statement = db.connect().createStatement();
				// get skill id's associated with user id
				ResultSet skills = statement.executeQuery(
						"SELECT tat_user_skill.Skill_Id, tat_skill.Name, "
								+ "tat_user_skill.Weight "
								+ "FROM tat_skill INNER JOIN tat_user_skill "
								+ "ON tat_skill.Id = tat_user_skill.Skill_Id "
								+ "WHERE tat_user_skill.User_Id = " + user_id);

				// get all skill information
				while (skills.next())
				{
					int skill_id = skills.getInt("Skill_Id");
					String name = skills.getString("Name");
					int weight = skills.getInt("Weight");

					// create skill object
					Skill skill = new Skill(skill_id, name, weight);

					// for now just add int and string to skills
					skill_list.add(skill);

				}

				// add skill list to student object
				student.setActual_skills(skill_list);
			} catch (SQLException e)
			{
				e.printStackTrace();
				Helper_utilities.print_error_message(e);
			}
		}
	}

	/**
	 * Loads the required project data from database into CourseInstanceIteration
	 * object's projects ArrayList based on the objects course_instance_id.
	 * 
	 * @param db
	 *           - database connection
	 * @param ci_iteration
	 *           - CourseInstanceIteration object
	 */
	public void load_project_data(DatabaseConnection db,
			CourseInstanceIteration ci_iteration)
	{
		Statement statement;
		// Initialize empty array list
		ArrayList<Project> project_list = new ArrayList<Project>();
		int total_max_students = 0;
		int total_min_students = 0;

		try
		{
			statement = db.connect().createStatement();
			ResultSet results = statement.executeQuery(
					"SELECT tat_course_project.Project_Id, tat_project.Title, "
							+ "tat_project.Description, tat_project.Type, "
							+ "tat_project.Size_Min, tat_project.Size_Max "
							+ "FROM tat_project INNER JOIN tat_course_project "
							+ "ON tat_project.Id = tat_course_project.Project_Id "
							+ "WHERE tat_course_project.Course_Instance_Id = "
							+ ci_iteration.getInstance_id());

			// iterate through results
			while (results.next())
			{
				// retrieve row column values
				int project_id = results.getInt("Project_Id");
				String name = results.getString("Title");
				String short_desc = results.getString("Description");
				String type = results.getString("Type");
				byte min_size = results.getByte("Size_Min");
				byte max_size = results.getByte("Size_Max");

				if (min_size > max_size)
				{
					String s = "Min student number larger than max student number for project: "
							+ name;
					ExitToWeb.exit_on_finish(s, db, this, ci_iteration);
				}

				total_min_students += min_size;
				total_max_students += max_size;

				// create project object
				Project project = new Project(project_id, name, short_desc, type,
						min_size, max_size);

				project_list.add(project);
				// ci_iteration.add_project_to_CourseInstance(project);

			}
			// add project list to CourseInstanceIteration object
			ci_iteration.setProjects(project_list);
			ci_iteration.setSum_max_project_students(total_max_students);
			ci_iteration.setSum_min_project_students(total_min_students);

		} catch (SQLException e)
		{
			e.printStackTrace();
			Helper_utilities.print_error_message(e);
		}

		// update courseInstanceIteration number of projects
		ci_iteration.setCount_number_projects();

	}

	/**
	 * load_project_requirements iterates through project ArrayList and using
	 * project IDs looks for any associated skills inside the
	 * tat_project_requirements table, then fetches details of each skill based
	 * on those results, creates a corresponding ProjectSkill object and saves it
	 * to the corresponding project object's lecturer_skills ArrayList.
	 * 
	 * @param db
	 *           - database connection
	 * @param projects
	 *           - ArrayList of ProjectSkill objects, most likely empty
	 */
	public void load_project_requirements(DatabaseConnection db,
			ArrayList<Project> projects)
	{
		Statement statement;

		// iterate through entire student hashmap
		for (Project project : projects)
		{
			// Initialize empty array list
			ArrayList<ProjectSkill> skill_list = new ArrayList<ProjectSkill>();
			// retrieve id
			int id = project.getProject_id();

			try
			{
				statement = db.connect().createStatement();
				ResultSet results = statement
						.executeQuery("SELECT tat_project_requirements.Skill_Id,"
								+ "tat_skill.Name, tat_project_requirements.Weight "
								+ "FROM tat_skill INNER JOIN tat_project_requirements "
								+ "ON tat_skill.id = tat_project_requirements.skill_id "
								+ "WHERE tat_project_requirements.project_id = " + id);

				// retrieve results data
				while (results.next())
				{
					int skill_id = results.getInt("Skill_Id");
					String name = results.getString("Name");
					int weight = results.getInt("Weight");

					// build skill object
					ProjectSkill skill = new ProjectSkill(skill_id, name, weight);

					// add skill to project
					skill_list.add(skill);
					// project.add_project_skill(skill);
				}
				project.setLecturer_skills(skill_list);

			} catch (SQLException e)
			{
				e.printStackTrace();
				Helper_utilities.print_error_message(e);
			}
		}
	}

	/**
	 * Executes the passed in query string sql for the database.
	 * 
	 * @param db
	 *           - database connection
	 * @param sql
	 *           - String to process
	 */
	public void saveData(DatabaseConnection db, String sql)
	{
		try
		{
			Statement statement;
			statement = db.connect().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
			Helper_utilities.print_error_message(e);
		}
	}

	/**
	 * Clears data from the tat_project_user table related to this instances
	 * objects projects and students. Used in the even the lecturer/project
	 * manager re-runs the algorithm for a course instance.
	 * 
	 * @param db
	 *           - DatabaseConnection object
	 * @param ci_iteration
	 *           - CourseInstanceIteration object
	 */
	public void rerun_reset(DatabaseConnection db,
			CourseInstanceIteration ci_iteration)
	{
		for (Project project : ci_iteration.getProjects())
		{
			int project_id = project.getProject_id();
			// for (ProjectTeamMember ptm : project.getProject_team_members()) {
			// int user_id = ptm.get_id();
			try
			{
				Statement statement = db.connect().createStatement();
				String sql = "DELETE FROM tat_project_user" + " WHERE project_id = "
						+ project_id;
				// + " AND user_id = " + user_id;
				statement.execute(sql);

			} catch (SQLException e)
			{
				e.printStackTrace();
				Helper_utilities.print_error_message(e);
			}

			// }
		}
	}
}
