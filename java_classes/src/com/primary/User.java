package com.primary;

public abstract class User
{
	private int id;
	private String first_name;
	private String last_name;
	private String email;

	/**
	 * Construct a User class object.
	 * 
	 * @param id
	 *           - the user id
	 * @param first_name
	 *           - users first name
	 * @param last_name
	 *           - users last name
	 * @param email
	 *           - users email
	 */
	public User(int id, String first_name, String last_name, String email) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	/* Getter and Setter for User class */

	// Class getters //
	/**
	 * Returns the value of this object's id attribute.
	 * 
	 * @return an integer
	 */
	public int get_id()
	{
		return this.id;
	}

	/**
	 * Returns the value of this object's first_name attribute.
	 * 
	 * @return a String
	 */
	public String get_first_name()
	{
		return this.first_name;
	}

	/**
	 * Returns the value of this object's last_name attribute.
	 * 
	 * @return a String
	 */
	public String get_last_name()
	{
		return this.last_name;
	}

	/**
	 * Returns the value of this object's email attribute.
	 * 
	 * @return a String
	 */
	public String get_email()
	{
		return this.email;
	}

	// Class setters //
	/**
	 * Sets this object's id attribute as the passed in parameter value.
	 * 
	 * @param new_id
	 *           - integer to be set
	 */
	public void set_id(int new_id)
	{
		this.id = new_id;
	}

	/**
	 * Sets this object's first_name attribute as the passed in parameter value.
	 * 
	 * @param new_first_name
	 *           - String to be set
	 */
	public void set_first_name(String new_first_name)
	{
		this.first_name = new_first_name;
	}

	/**
	 * Sets this object's last_name attribute as the passed in parameter value.
	 * 
	 * @param new_last_name
	 *           - String to be set.
	 */
	public void set_last_name(String new_last_name)
	{
		this.last_name = new_last_name;
	}

	/**
	 * Sets this object's email attribute as the passed in parameter value.
	 * 
	 * @param new_email
	 *           - String to be set
	 */
	public void set_email(String new_email)
	{
		this.email = new_email;
	}
}
