package com.primary;

import java.util.ArrayList;

public class Student extends User
{

	private ArrayList<Skill> actual_skills;
	private String skills_updated;

	/**
	 * Construct a Student class object.
	 * 
	 * @param id - an integer to be set
	 * @param first_name - a String to be set
	 * @param last_name - a String to be set
	 * @param email - a String to be set
	 * @param skills_updated - a String to be set
	 */
	public Student(int id, String first_name, String last_name, String email,
			String skills_updated) {
		super(id, first_name, last_name, email);

		this.actual_skills = new ArrayList<Skill>();
		this.skills_updated = skills_updated;
	}

	/**
	 * Deep copy constructor for the Student class.
	 * @param student - a Student object.
	 */
	public Student(Student student) {
		super(student.get_id(), student.get_first_name(), student.get_last_name(), student.get_email());
		this.actual_skills = student.actual_skills;
		this.skills_updated = student.skills_updated;
	}

	/* Getters */
	/**
	 * Returns this object's actual_skills ArrayLis.
	 * 
	 * @return an ArrayList of Skill objects
	 */
	public ArrayList<Skill> get_skills()
	{
		return actual_skills;
	}

	/**
	 * Returns the value of this object's skills_updated attribute.
	 * 
	 * @return a String
	 */
	public String get_Skills_Updated()
	{
		return skills_updated;
	}

	/**
	 * Fetches a single skill out of this object's actual_skills ArrayList by
	 * searching using skill_id.
	 * 
	 * @param skill_id
	 *           - an integer value to search
	 * 
	 * @return returns a Skill object, or null if skill not found
	 */
	public Skill get_single_skill(int skill_id)
	{
		for (Skill skill : actual_skills)
		{
			if (skill.get_id() == skill_id)
			{
				return skill;
			}
		}
		return null;
	}

	/* Setters */

	/**
	 * Adds the passed in parameter to this object's actual_skills ArrayList.
	 * 
	 * @param new_skill
	 *           - a Skill object
	 */
	public void add_skill(Skill new_skill)
	{
		this.actual_skills.add(new_skill);
	}

	/**
	 * Sets this object's actual_skills ArrayList as the passed in ArrayList.
	 * 
	 * @param actual_skills
	 *           - ArrayList of Skill objects
	 */
	public void setActual_skills(ArrayList<Skill> actual_skills)
	{
		this.actual_skills = actual_skills;
	}

	/**
	 * Sets this objects skills_updated attribute to the passed in parameter
	 * value.
	 * 
	 * @param status
	 *           - a String value to set
	 */
	public void setSkills_Updated(String status)
	{
		skills_updated = status;
	}

}
