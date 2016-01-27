package com.primary;

public class Skill
{
	private int id; // should probably rename to skill_id
	private String name;
	// private String skill_level; // refers to word description of weighting -->
	// this is currently only hardcoded into php pages
	private int weighting;

	/**
	 * Constructs a Skill class object.
	 * 
	 * @param id
	 *           - an integer to be set
	 * @param name
	 *           - - a String to be set
	 * @param weighting
	 *           - integer to be set
	 */
	public Skill(int id, String name, int weighting) {
		this.id = id;
		this.name = name;
		this.weighting = weighting;
	}

	/**
	 * Construct a Skill class object.
	 * 
	 * @param name
	 *           - a String to be set.
	 * @param weighting
	 *           - an integer to be set.
	 */
	public Skill(String name, int weighting) {
		this.name = name;
		this.weighting = weighting;
		this.id = 0; // used to set dummy skill id to 0
	}

	/* Getters */
	/**
	 * Returns the value of this object's Id attribute.
	 * 
	 * @return integer value
	 */
	public int get_id()
	{
		return this.id;
	}

	/**
	 * Returns the value of this object's name attribute.
	 * 
	 * @return string value
	 */
	public String get_name()
	{
		return this.name;
	}

	/**
	 * Returns the value of this objects weighting attribute.
	 * 
	 * @return integer value
	 */
	public int get_weighting()
	{
		return this.weighting;
	}

	/* Setters */

	/**
	 * Sets this object's id attribute as the passed in parameter value.
	 * 
	 * @param new_id - integer value
	 */
	public void set_id(int new_id)
	{
		this.id = new_id;
	}

	/**
	 * Sets this object's name attribute as the passed in parameter value.
	 * 
	 * @param new_name - string value
	 */
	public void set_name(String new_name)
	{
		this.name = new_name;
	}

	/**
	 * Sets this object's weighting attribute as the passed in parameters value.
	 * 
	 * @param new_weighting - integer value
	 */
	public void set_weighting(int new_weighting)
	{
		this.weighting = new_weighting;
	}
}
