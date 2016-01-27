package com.primary;

import java.util.ArrayList;

/**
 * A basic CourseInstance class.
 */
public class CourseInstance
{
	private int instance_id;
	private String course_code;
	private String course_name;
	private int year;
	private String study_period;
	private String ci_status; // status of course instance -
	// inactive/active_incomplete/active_complete/interim/approved
	private String lecturer; // will this be a lecturer name or lecturer ID?
	private ArrayList<Project> projects;
	private ArrayList<Student> students;
	private int count_number_projects;
	private double overall_balance;

	/**
	 * Constructor for CourseInstance class
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
	 */
	public CourseInstance(int instance_id, String course_code,
			String course_name, int year, String study_period, String ci_status,
			String lecturer) {
		super();
		this.instance_id = instance_id;
		this.course_code = course_code;
		this.course_name = course_name;
		this.year = year;
		this.study_period = study_period;
		this.ci_status = ci_status;
		this.lecturer = lecturer;
		this.projects = new ArrayList<Project>();
		this.students = new ArrayList<Student>();
	}

	/* Getters and Setters */

	/**
	 * Returns the value of this object's instance_id attribute
	 * 
	 * @return integer
	 */
	public int getInstance_id()
	{
		return this.instance_id;
	}

	/**
	 * Sets the value of this object's instance_id attribute to the passed in
	 * parameter.
	 * 
	 * @param new_instance_id
	 *           - integer to be set
	 */
	public void setInstance_id(int new_instance_id)
	{
		this.instance_id = new_instance_id;
	}

	/**
	 * Returns the value of this object's course_code attribute
	 * 
	 * @return String
	 */
	public String getCourse_code()
	{
		return course_code;
	}

	/**
	 * Sets the value of this object's course_code attribute to the passed in
	 * parameter.
	 * 
	 * @param course_code
	 *           - String to be set
	 */
	public void setCourse_code(String course_code)
	{
		this.course_code = course_code;
	}

	/**
	 * Returns the value of this object's course_name attribute.
	 * 
	 * @return String
	 */
	public String getCourse_name()
	{
		return course_name;
	}

	/**
	 * Sets the value of this object's course_name attribute to the passed in
	 * parameter.
	 * 
	 * @param course_name
	 *           - String to be set
	 */
	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}

	/**
	 * Returns the value of this object's year parameter.
	 * 
	 * @return integer
	 */
	public int getYear()
	{
		return this.year;
	}

	/**
	 * Sets the value of this object's year attribute to the passed in parameter.
	 * 
	 * @param year
	 *           - integer to be set
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

	/**
	 * Returns the value of this object's study_period attribute.
	 * 
	 * @return String
	 */
	public String getStudy_period()
	{
		return this.study_period;
	}

	/**
	 * Sets the value of this object's study_period attribute to the passed in
	 * parameter.
	 * 
	 * @param study_period
	 *           - String to be set
	 */
	public void setStudy_period(String study_period)
	{
		this.study_period = study_period;
	}

	/**
	 * Returns the value of this object's ci_status attribute.
	 * 
	 * @return String
	 */
	public String getCi_status()
	{
		return ci_status;
	}

	/**
	 * Sets the value of this object's ci_status attribute to the passed in
	 * parameter.
	 * 
	 * @param ci_status
	 *           - String to be set
	 */
	public void setCi_status(String ci_status)
	{
		this.ci_status = ci_status;
	}

	/**
	 * Returns the value of this object's lecturer attribute.
	 * 
	 * @return String
	 */
	public String getLecturer()
	{
		return this.lecturer;
	}

	/**
	 * Sets the value of this object's lecturer attribute to the passed in
	 * parameter.
	 * 
	 * @param lecturer
	 *           - String to be set
	 */
	public void setLecturer(String lecturer)
	{
		this.lecturer = lecturer;
	}

	/**
	 * Returns the values of this object's projects ArrayList.
	 * 
	 * @return ArrayList of Project objects
	 */
	public ArrayList<Project> getProjects()
	{
		return this.projects;
	}

	/**
	 * Sets this object's projects ArrayList as the passed in parameter.
	 * 
	 * @param projects
	 *           - ArrayList of Project objects
	 */
	public void setProjects(ArrayList<Project> projects)
	{
		this.projects = projects;
	}
	
	/**
	 * Sets this objects projects ArrayList to empty using the clear command
	 * 	 * 
	 */
	public void setProjectsEmpty(){
		this.projects.clear();
	}

	public ArrayList<Student> getStudents()
	{
		return this.students;
	}

	/**
	 * Iterates through CourseInstance object students array list in order to
	 * find a a student objects matching id. When found, returns that student
	 * object.
	 * 
	 * @param student_id
	 *           - integer to search for
	 * @return a Student object
	 */
	public Student getA_student(int student_id)
	{
		for (Student s : students)
		{

			if (student_id == s.get_id())
			{
				return s;
			}
		}
		return null;
	}

	/**
	 * Sets this object's students ArrayList to the passed in parameter.
	 * 
	 * @param students
	 *           - ArrayList of Student objects
	 */
	public void setStudents(ArrayList<Student> students)
	{
		this.students = students;
	}

	/**
	 * Returns the value of this object's overall_balance attribute.
	 * 
	 * @return integer
	 */
	public double getOverall_balance()
	{
		return this.overall_balance;
	}

	/**
	 * Sets the value of this object's overall_balance attribute to the passed in
	 * parameter.
	 * 
	 * @param overall_balance
	 *           - integer to be set
	 */
	public void setOverall_balance(double overall_balance)
	{
		this.overall_balance = overall_balance;
	}

	/**
	 * Returns the value of this object's count_number_projects attribute.
	 * 
	 * @return integer
	 */
	public int getCount_number_projects()
	{
		return count_number_projects;
	}

	/**
	 * Sets the value of this object's count_number_projects attribute as the
	 * passed in parameter.
	 * 
	 * @param count_number_projects
	 *           - integer to be set
	 */
	public void setCount_number_projects(int count_number_projects)
	{
		this.count_number_projects = count_number_projects;
	}

	/**
	 * Sets the count of count_number_projects to the return value of the
	 * size method called on projects ArrayList.
	 */
	public void setCount_number_projects()
	{
		count_number_projects = projects.size();
	}
}
