package testing;

import java.util.ArrayList;

import com.primary.CourseInstanceIteration;
import com.primary.Project;
import com.primary.ProjectSkill;
import com.primary.ProjectTeamMember;
import com.primary.Skill;
import com.primary.Student;

public class TestFunctions
{

	public static String[] createArray(ArrayList<String> al)
	{
		String[] arg = new String[al.size()];
		arg = al.toArray(arg);
		return arg;
	}

	public static void test_print_course_instance(CourseInstanceIteration ci)
	{
		System.out
				.println("\n--------------------------------------------------");
		System.out.println("Course Instance Iteration Details");
		System.out.println("--------------------------------------------------");
		System.out.print("\nInstance ID: " + ci.getInstance_id()
				+ "\nCourse Code: " + ci.getCourse_code() + "\nCourse Name: "
				+ ci.getCourse_name() + "\nYear: " + ci.getYear()
				+ "\nStudy Period: " + ci.getStudy_period() + "\nStatus: "
				+ ci.getCi_status() + "\nLecturer ID: " + ci.getLecturer()
				+ "\nNumber of Projects: " + ci.getCount_number_projects()
				+ "\nOverall Balance: " + ci.getOverall_balance()
				+ "\nMethodology: " + ci.getMethodology() + "\nMax Run Time: "
				+ ci.getMax_run_time() + "\nSum Max Project Students: "
				+ ci.getSum_max_project_students() + "\nSum Min Project Students: "
				+ ci.getSum_min_project_students() + "\nCount Students: "
				+ ci.getCount_students() + "\nStart_Time: " + ci.getStart_time()
				+ "\nIteration Count " + ci.getIteration_count()
				+ "\nCurrent_Overll_balance: " + ci.getCurrent_overall_balance());
		System.out.println("\n");
	}

	public static void test_print_projects(CourseInstanceIteration ci)
	{
		for (Project project : ci.getProjects())
		{
			System.out
					.println("---------------------------------------------------");
			System.out.println("Project Details for " + ci.getCourse_name());
			System.out
					.println("---------------------------------------------------");
			System.out.print("\nProject ID: " + project.getProject_id()
					+ "\nProject Name: " + project.getName() + "\nDescription: "
					+ project.getShort_desc() + "\nStatus: "
					+ project.getIncomplete_status() + "\nProject Type: "
					+ project.getType() + "\nMin Team Size: " + project.getMin_size()
					+ "\nMax Team Size: " + project.getMax_size()
					+ "\nCurrent Project Team Distance: "
					+ project.getCurrent_project_team_distance()
					+ "\nList of required skills:");
			test_print_skills(project.getLecturer_skills());
			System.out.print("\n");
		}
	}

	// generic function to make it work with skill and projectskill class
	public static <T> void test_print_skills(ArrayList<T> skills)
	{
		for (T skill : skills)
		{
			System.out.println("\n\tSkill ID: " + ((Skill) skill).get_id()
					+ "\n\tSkill Name: " + ((Skill) skill).get_name()
					+ "\n\tSkill Weighting: " + ((Skill) skill).get_weighting());
		}
	}

	public static void test_print_student_details(ArrayList<Student> students)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Students in course instance:");
		System.out.println("--------------------------------------------------");
		for (Student student : students)
		{
			System.out.print("\nStudent Name: " + student.get_first_name() + " "
					+ student.get_last_name() + "\nUser ID: " + student.get_id());
			ArrayList<Skill> skills = student.get_skills();
			System.out.print("\nList of Skills:");
			test_print_skills(skills);
			System.out.print("\n\n");
		}
	}

	public static void test_print_project_team(
			CourseInstanceIteration ci_iteration)
	{
		for (Project project : ci_iteration.getProjects())
		{
			System.out
					.print("\n--------------------------------------------------");
			System.out.print("\nProject team member for: " + project.getName());
			System.out.print("\nProject Team Member array size: "
					+ project.getCurrent_team_size());
			for (ProjectTeamMember ptm : project.getProject_team_members())
			{
				System.out.print("\n\tUser ID: " + ptm.get_id()
						+ "\n\tAssigned Skill ID: " + ptm.getAssigned_skill_id()
						+ "\n\tStudent Skill Weight: "
						// + ptm.getStudent_skill_weighting()
						+ "\n\tProject Skill Weight: "
						// + ptm.getProject_skill_weighting() +
						+ "\n\t----");
			}
		}

	}

	public static void testprint(CourseInstanceIteration ci)
	{

		System.out.println("\n\n\n===========================\n");
		System.out.println(ci.getCourse_name() + " : " + ci.getYear() + ":"
				+ ci.getStudy_period());
		System.out.println("Iteration Count: " + ci.getIteration_count()
				+ "  Overall Balance: " + ci.getOverall_balance());
		System.out.println("Course Instance Status: " + ci.getCi_status());
		System.out.println("Min: " + ci.getSum_min_project_students()
				+ "  Students: " + ci.getCount_students() + "  Max: "
				+ ci.getSum_max_project_students());

		System.out.printf("\n%-4s, %-20s, %-8s, %-8s, %-8s, %-8s, %-8s\n", "Id",
				"Name", "MinSize", "MaxSize", "#Members", "#Skills", "Distance");

		for (Project p : ci.getProjects())
		{
			System.out.printf("%-4s, %-20s, %-8s, %-8s, %-8s, %-8s, %-8s\n",
					p.getProject_id(), p.getName(), p.getMin_size(), p.getMax_size(),
					p.getCurrent_team_size(), p.getLecturer_skills().size(),
					p.getCurrent_project_team_distance());

			System.out.println(
					"----------------------------------------------------------------");
			System.out.printf(
					"%10s %-20s, %-5s, %-15s, %-15s, %-5s, %-20s, %-5s, %-10s, %-10s\n",
					"", "Lecturer Skill", "LS_Id", "FName", "LName", "Id",
					"Assgn Skill Name", "S_Id", "S_Weight", "P_Weight");

			for (ProjectSkill ps : p.getLecturer_skills())
			{
				if (ps.isAssigned())
				{
					if (ps.get_id() == 0)
					{

						System.out.println("Dummy skill .... need to check database");

					} else
					{
						ProjectTeamMember ptm = p
								.getA_project_team_member(ps.get_id());
						Student s = ci.getA_student(ptm.get_id());
						for (Skill skill : s.get_skills())
						{
							if (skill.get_id() == ps.get_id())
							{
								System.out.printf(
										"%10s %-20s, %-5s, %-15s, %-15s, %-5s, %-20s, %-5s, %-10s, %-10s\n",
										"", ps.get_name(), ps.get_id(),
										s.get_first_name(), s.get_last_name(),
										ptm.get_id(),
										p.getA_lecturer_skill(ptm.getAssigned_skill_id())
												.get_name(),
										ptm.getAssigned_skill_id(),
										skill.get_weighting(),
										ps.get_weighting());
							}
						}
					}
				} else
				{
					System.out.printf("%10s %-20s, %-5s, %80s, %-10s\n", "",
							ps.get_name(), ps.get_id(), "", ps.get_weighting());
				}
			}
		}

	}

}
