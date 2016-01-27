package com.primary;

public class ProjectTeamMember extends Student
{
	private int assigned_skill_id;

	/**
	 * Construct a ProjectTeamMember object.
	 * 
	 * @param id
	 *           - an integer to be set
	 * @param first_name
	 *           - a String to be set
	 * @param last_name
	 *           - a String to be se
	 * @param email
	 *           - a String to be se
	 * @param skills_updated
	 *           - a String to be se
	 * @param assigned_skill_id
	 *           - an integer to be set
	 */
	public ProjectTeamMember(int id, String first_name, String last_name,
			String email, String skills_updated, int assigned_skill_id) {
		super(id, first_name, last_name, email, skills_updated);
		this.assigned_skill_id = assigned_skill_id;
	}

	/**
	 * Partial copy constructor used to convert a Student object to a
	 * ProjectTeamMember object, used when a Student object is matched to a
	 * Skill.
	 * 
	 * @param ptm
	 *           - a Student object to be copied
	 * @param assigned_skill_id
	 *           - an integer value to be set
	 */
	public ProjectTeamMember(Student ptm, int assigned_skill_id) {
		super(ptm);
		this.assigned_skill_id = assigned_skill_id;
	}

	/**
	 * Deep copy constructor for ProjectTeamMember class
	 * 
	 * @param ptm
	 *           - ProjectTeamMember object to be copied
	 */
	public ProjectTeamMember(ProjectTeamMember ptm) {
		super(ptm);
		this.assigned_skill_id = ptm.getAssigned_skill_id();
	}

	/* Getters and Setters */
	/**
	 * Returns the value for this object's assigned_skill_id attribute.
	 * 
	 * @return - integer
	 */
	public int getAssigned_skill_id()
	{
		return assigned_skill_id;
	}

	/**
	 * Sets this object's assigned_skill_id attributes as the passed in
	 * parameter.
	 * 
	 * @param assigned_skill_id
	 *           - integer to be set.
	 */
	public void setAssigned_skill_id(int assigned_skill_id)
	{
		this.assigned_skill_id = assigned_skill_id;
	}

}
