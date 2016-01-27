package com.primary;

import java.util.ArrayList;
import java.util.Collections;

public class Project
{
	/* Class attributes */
	private int project_id;
	private String name;
	private String short_desc;
	private Boolean incomplete_status; // is needed to manage incomplete status
												  // in cycle 1A
	private String type;
	private byte min_size, max_size; // max values (negative) 128 -
	// (positive)127
	private int current_project_team_distance;
	// changed from ProjectTeamMember to string to make it easy ATM
	private ArrayList<ProjectTeamMember> project_team_members;
	private ArrayList<ProjectSkill> lecturer_skills;

	/**
	 * Constructs a Project class objec.t
	 * 
	 * @param project_id
	 *           - integer to be set
	 * @param name
	 *           - String to be set
	 * @param short_desc
	 *           - string to be set
	 * @param type
	 *           - String to be set
	 * @param min_size
	 *           - byte to be set
	 * @param max_size
	 *           - byte to be set
	 */
	public Project(int project_id, String name, String short_desc, String type,
			byte min_size, byte max_size) {
		this.project_id = project_id;
		this.name = name;
		this.short_desc = short_desc;
		this.type = type;
		this.min_size = min_size;
		this.max_size = max_size;
		this.project_team_members = new ArrayList<ProjectTeamMember>();
		this.lecturer_skills = new ArrayList<ProjectSkill>();

		this.incomplete_status = false;
	}

	/**
	 * Deep copy constructor for Project class. Used when creating a Project
	 * object for the random_project ArrayList of the CourseInstanceIteration
	 * class object.
	 * 
	 * @param source
	 *           - a Project object to be copied.
	 * 
	 */
	public Project(Project source, String control_variable) {
		this.project_id = source.project_id;
		this.name = source.name;
		this.short_desc = source.short_desc;
		this.type = source.type;
		this.min_size = source.min_size;
		this.max_size = source.max_size;

		this.project_team_members = new ArrayList<ProjectTeamMember>();
		
		if (control_variable.equalsIgnoreCase("to_primary")){
			
			for (ProjectTeamMember ptm : source.getProject_team_members()){
				this.project_team_members.add(new ProjectTeamMember(ptm));
			}
			
			this.current_project_team_distance = source.getCurrent_project_team_distance();
			this.incomplete_status = source.getIncomplete_status();
			
		}
		else {
			
			this.incomplete_status = false;
			this.current_project_team_distance = 0;
			
		}
		
		
		this.lecturer_skills = new ArrayList<ProjectSkill>();

		for (ProjectSkill ps : source.lecturer_skills)
		{
			if (!ps.get_name().equalsIgnoreCase("Dummy"))
			{
				this.lecturer_skills.add(new ProjectSkill(ps));
			}
		}

		
	}

	/* Getters and Setters */
	/**
	 * Returns the value of this object's project_id attribute.
	 * 
	 * @return - integer
	 */
	public int getProject_id()
	{
		return project_id;
	}

	/**
	 * Sets this object's project_id attribute as the passed in parameter value.
	 * 
	 * @param project_id
	 *           - integer to be set
	 */
	public void setProject_id(int project_id)
	{
		this.project_id = project_id;
	}

	/**
	 * Returns the value of this object's name attribute.
	 * 
	 * @return - a String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Set this object's name attribute as the passed in parameter value.
	 * 
	 * @param name
	 *           - a String to be set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Returns the value of this object's short_desc attribute.
	 * 
	 * @return - a String
	 */
	public String getShort_desc()
	{
		return short_desc;
	}

	/**
	 * Set this object's short_desc attribute as the passed in parameter value.
	 * 
	 * @param short_desc
	 *           - a String to be set
	 */
	public void setShort_desc(String short_desc)
	{
		this.short_desc = short_desc;
	}

	/**
	 * Returns the value of this object's incomplete_status attribute.
	 * 
	 * @return - a boolean
	 */
	public Boolean getIncomplete_status()
	{
		return incomplete_status;
	}

	/**
	 * Sets this object's incomplete status attribute as the passed in parameter
	 * value.
	 * 
	 * @param status
	 *           - a boolean to be set
	 */
	public void setIncomplete_status(Boolean status)
	{
		this.incomplete_status = status;
	}

	/**
	 * Returns the value of this object's type attribute.
	 * 
	 * @return - String
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Sets this object's type attribute as the passed in parameter value.
	 * 
	 * @param type -
	 *           a String to be set
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Returns the value of this object's min_size attribute.
	 * 
	 * @return byte
	 */
	public byte getMin_size()
	{
		return min_size;
	}

	/**
	 * Sets this object's min_size attribute as the passed in parameter value.
	 * 
	 * @param min_size -
	 *           an byte to be set
	 */
	public void setMin_size(byte min_size)
	{
		this.min_size = min_size;
	}

	/**
	 * Returns the value of this object's max_size attribute.
	 * 
	 * @return byte
	 */
	public byte getMax_size()
	{
		return max_size;
	}

	/**
	 * Sets this object's max_size attribute as the passed in parameter value.
	 * 
	 * @param max_size -
	 *           an byte to be set
	 */
	public void setMax_size(byte max_size)
	{
		this.max_size = max_size;
	}

	/**
	 * Returns the value of this object's current_project_team_distance
	 * attribute.
	 * 
	 * @return - integer
	 */
	public int getCurrent_project_team_distance()
	{
		return current_project_team_distance;
	}

	/**
	 * Calculates the team distance by subtracting the total required project
	 * skills weightings from the total of already assigned students skills
	 * weightings.
	 * 
	 * @return - integer
	 */
	public int calculate_project_team_distance_sum_minus_sum()
	{
		// implement using formula:
		// sum(project_skill_weighting) - sum(student_skill_weighting)
		int team_distance = Math.abs(this.get_total_project_skill_weightings()
				- this.get_total_student_skills_weightings());
		this.current_project_team_distance = team_distance;
		return team_distance;
	}

	/**
	 * Sets this object's current_project_team_distance attribute as the passed
	 * in parameter value.
	 * 
	 * @param current_project_team_distance -
	 *           an integer to be set
	 */
	public void setCurrent_project_team_distance(
			int current_project_team_distance)
	{
		this.current_project_team_distance = current_project_team_distance;
	}

	/**
	 * Returns this object's project_team_member ArrayList. objects.
	 * 
	 * @return - ArrayList of ProjectTeamMembers
	 */
	public ArrayList<ProjectTeamMember> getProject_team_members()
	{
		return project_team_members;
	}

	/**
	 * Iterates over the projectTeamMembers arrays list in order to find an
	 * object that matches the given assigned_skill_id parameter. When a match is
	 * found, it returns the projectTeamMember object.
	 * 
	 * @param assigned_skill_id
	 *           - integer to search for
	 * @return - projectTeamMember object, or null if no match found
	 */
	public ProjectTeamMember getA_project_team_member(int assigned_skill_id)
	{

		for (ProjectTeamMember ptm : project_team_members)
		{

			if (assigned_skill_id == ptm.getAssigned_skill_id())
			{
				return ptm;
			}
		}
		return null;
	}

	/**
	 * Sets this object's project_team_members ArrayList as the passed in
	 * parameter.
	 * 
	 * @param project_team_members
	 *           - ArrayList of ProjectTeamMember objects
	 */
	public void setProject_team_members(
			ArrayList<ProjectTeamMember> project_team_members)
	{
		this.project_team_members = project_team_members;
	}

	/**
	 * Adds the passed in object to this object's project_team_members ArrayList.
	 * @param ptm - ProjectTeamMember object
	 */
	public void add_single_team_member(ProjectTeamMember ptm)
	{
		this.project_team_members.add(ptm);
	}

	/**
	 * Returns this object's lecturer_skills ArrayList.
	 * 
	 * @return - ArrayList of ProjectSkill objects.
	 */
	public ArrayList<ProjectSkill> getLecturer_skills()
	{
		return lecturer_skills;
	}

	/**
	 * Iterates over the lecturer_skills arraylist in order to find a match for
	 * the given skill_id parameter. When a match is found, the skill object is
	 * returned.
	 * 
	 * @param skill_id
	 *           - an integer to be set
	 * @return - a Skill object
	 */
	public Skill getA_lecturer_skill(int skill_id)
	{
		for (Skill s : lecturer_skills)
		{

			if (skill_id == s.get_id())
			{
				return s;
			}
		}
		return null;
	}

	/**
	 * Adds a single skill to Project objects lecturer_skills array list.
	 * 
	 * @param skill
	 *           - a Skill object
	 */
	public void add_project_skill(ProjectSkill skill)
	{
		this.lecturer_skills.add(skill);
	}

	/**
	 * Sets this objects lecturer_skills ArrayList as the passed in parameter.
	 * 
	 * @param lecturer_skills
	 *           - ArrayList of ProjectSkill objects
	 */
	public void setLecturer_skills(ArrayList<ProjectSkill> lecturer_skills)
	{
		this.lecturer_skills = lecturer_skills;
	}

	/**
	 * Returns the current size of this object's project_team_members ArrayList.
	 * 
	 * @return - integer value.
	 */
	public int getCurrent_team_size()
	{
		return project_team_members.size();
	}

	/**
	 * Iterates through lecturer_skills array to find highest modified skill
	 * weighting value and returns it.
	 * 
	 * @return - integer
	 */
	public int get_highest_skill_weighting()
	{
		int highest_weighting = 0;
		for (ProjectSkill skill : lecturer_skills)
		{
			// ensure to get modified skill weightings
			if (skill.isAssigned() == false
					&& skill.getModified_weighting() > highest_weighting)
			{
				highest_weighting = skill.getModified_weighting();
			}
		}
		return highest_weighting;
	}

	/**
	 * Builds an array of skills whose skill weighting value matches the given
	 * parameter value, then returns the array list.
	 * 
	 * @param weighting
	 *           - an integer to be matched
	 * @return - ArrayList of ProjectSkill objects
	 */
	public ArrayList<ProjectSkill> skills_based_on_weighting(int weighting)
	{
		ArrayList<ProjectSkill> skills = new ArrayList<ProjectSkill>();
		for (ProjectSkill skill : this.lecturer_skills)
		{
			if (skill.getModified_weighting() == weighting)
			{
				skills.add(skill);
			}
		}

		return skills;
	}

	/**
	 * Calculate the total skill weighings of all unassigned skills belonging to
	 * this Project Object. Functions iterates through lecturer_skills list and
	 * checks if the skills 'assigned' attribute is marked false. If marked
	 * false, the weighting is added to total, otherwise it is ignored.
	 * 
	 * @return - an integer
	 */
	public int calculate_unassigned_skills_weightings()
	{
		int total_unassigned_skills_weightings = 0;

		// check if list is populated
		if (lecturer_skills.size() != 0)
		{
			// loop through each skill in project objects required skills list
			for (ProjectSkill skill : this.lecturer_skills)
			{
				if (this.getCurrent_team_size() == 0)
				{
					// if current team size is 0, no skills have been assigned
					total_unassigned_skills_weightings += skill
							.getModified_weighting();
				} else
				{
					// if skill assigned == false, add weighting to total
					if (skill.isAssigned() == false || skill.is_modified() == true)
					{
						total_unassigned_skills_weightings += skill
								.getModified_weighting();
					}
				}
			}
		}
		return total_unassigned_skills_weightings;
	}

	/**
	 * Sums the total skills weighting in the required skills list
	 * (lecturer_skills) for the current project object.
	 * 
	 * @return - an integer
	 */
	public int get_total_project_skill_weightings()
	{
		int total = 0;

		// check if list is populated
		if (lecturer_skills.size() != 0)
		{
			for (ProjectSkill skill : this.lecturer_skills)
			{
				// iterate through list and pull skills weight for each object
				total += skill.get_weighting();
			}
		}
		return total;
	}

	/**
	 * Sums the total skills weighting for students in the current
	 * project_team_member list for the current project object.
	 * 
	 * @return - an integer
	 */
	public int get_total_student_skills_weightings()
	{
		int total = 0;

		// check if list is populated
		if (project_team_members.size() != 0)
		{
			for (ProjectTeamMember ptm : project_team_members)
			{
				// get assigned_skill_id
				int assigned_skill_id = ptm.getAssigned_skill_id();
				for (Skill skill : ptm.get_skills())
				{
					// iterate team_members skills list to find matching
					// assigned_skill id
					if (skill.get_id() == assigned_skill_id)
					{
						// if match found, at to total, break out of current for loop
						total += skill.get_weighting();
						break;
					}
				}

			}
		}
		return total;
	}

	/**
	 * Iterates through lecturer_skills ArrayList looking for unassigned skills.
	 * If unassigned skill found, returns true. Else if no unassigned skill
	 * found, returns false.
	 * 
	 * @return a boolean value
	 */
	public boolean check_unassigned_skills()
	{
		for (ProjectSkill skill : this.lecturer_skills)
		{
			if (skill.isAssigned() == false)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Iterates lecturer_skills list and returns first unallocated skill.
	 * Lecturer_skill list is shuffle to make it random.
	 * 
	 * @return - Project skill object or null.
	 */
	public ProjectSkill get_unallocated_skill()
	{
		ArrayList<ProjectSkill> random_skills = this.lecturer_skills;
		Collections.shuffle(random_skills);
		for (ProjectSkill skill : random_skills)
		{
			if (skill.isAssigned() == false)
			{
				return skill;
			}
		}
		return null;
	}

	/**
	 * Calculates the team distance by summing the absolute value of the
	 * difference between the required project skill weighting from the assigned
	 * students skills weighting.
	 * 
	 * If no student has been assigned, treated as a zero weighting
	 * 
	 * @return - an integer value
	 */
	public int calculate_project_team_distance_sum_difference()
	{
		// implement using formula:
		// sum(abs(project_skill_weighting - student_skill_weighting))

		int team_distance = 0;

		for (ProjectSkill ps : lecturer_skills)
		{
			int student_weighting = 0;

			for (ProjectTeamMember ptm : project_team_members)
			{
				if (ps.get_id() == ptm.getAssigned_skill_id())
				{
					for (Skill skill : ptm.get_skills())
					{
						// iterate through team_members skills list
						if (skill.get_id() == ptm.getAssigned_skill_id())
						{
							// when skill id match found for assigned skill and skill
							// in students skills list
							// add to total sum of student_weighting
							student_weighting = skill.get_weighting();
							// student_weighting = ptm.getStudent_skill_weighting();
						}
					}
				}
			}
			team_distance += Math.abs(ps.get_weighting() - student_weighting);

		}
		this.current_project_team_distance = team_distance;
		return team_distance;
	}

}
