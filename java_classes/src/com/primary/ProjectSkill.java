package com.primary;

public class ProjectSkill extends Skill
{
	private boolean assigned;
	private int modified_weighting;
	private boolean modified;

	/**
	 * Constructs a ProjectSkill class object.
	 * 
	 * @param id
	 *           - an integer value to be set
	 * @param name
	 *           - a String value to be set
	 * @param weighting
	 *           - an integer value to be set
	 */
	public ProjectSkill(int id, String name, int weighting) {
		super(id, name, weighting);
		this.assigned = false;
		this.modified_weighting = weighting; // default value same as weighting
		this.modified = false; // default is false
	}

	/**
	 * Constructs a dummy ProjectSkill class object
	 * 
	 * @param name
	 *           - a String to be set
	 * @param weighting
	 *           - an integer to be set
	 */
	public ProjectSkill(String name, int weighting) {
		super(name, weighting);
		this.assigned = false;
		this.modified_weighting = weighting;
		this.modified = false;
	}

	/**
	 * Deep copy constructor for the ProjectSkill class.
	 * 
	 * @param projectSkill
	 *           - a ProjectSkill object
	 */
	public ProjectSkill(ProjectSkill projectSkill) {
		super(projectSkill.get_id(), projectSkill.get_name(),
				projectSkill.get_weighting());
		this.assigned = false;
		this.modified_weighting = projectSkill.get_weighting();
		this.modified = false;
	}

	/**
	 * Returns this object's current value of the assigned attribute.
	 * 
	 * @return a boolean
	 */
	public boolean isAssigned()
	{
		return assigned;
	}

	/**
	 * Sets this object's assigned attribute to the passed in parameter.
	 * 
	 * @param assigned
	 *           - a boolean to be set
	 */
	public void setAssigned(boolean assigned)
	{
		this.assigned = assigned;
	}

	/**
	 * Returns this object's current value of the modified_weighting attribute.
	 * 
	 * @return an integer
	 */
	public int getModified_weighting()
	{
		return modified_weighting;
	}

	/**
	 * Sets this object's modified_weighting attribute to the passed in parameter
	 * value.
	 * 
	 * @param modified_weighting
	 *           - integer to be set
	 */
	public void setModified_weighting(int modified_weighting)
	{
		this.modified_weighting = modified_weighting;
	}

	/**
	 * Returns this object's current value of the modified attribute.
	 * 
	 * @return a boolean
	 */
	public boolean is_modified()
	{
		return modified;
	}

	/**
	 * Sets this object's modified attribute to the passed in parameter value.
	 * 
	 * @param has_been_modified
	 *           - a boolean to be set
	 */
	public void set_modified(boolean has_been_modified)
	{
		this.modified = has_been_modified;
	}
}
