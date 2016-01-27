package testing;

import java.sql.SQLException;
import java.util.Arrays;
import com.primary.Main;

public class Tester
{

	public static void main(String[] args)
   {
		
	// remove all data from database
   	try
   	{
   
   		String[] arguments = new String[5]; 
   		String[] empty_arguments = new String[0];
   		
   		//
   		// TEST CASES 
   		//		- Testing algorithm only - not interaction with website
   		//		- Each course instance will hold conditions to be tested
   		//
   		// 	args required to be passed to main (in orgder): 
   		//			course_code, course_year, study_period, methodology, max_run_time
   		//			where course_code, course_year, study_period define the course_instance
   		
   		
   		// Database Connection Fails
   		
   		
   		
   		//
   		// No Data
   		//
   		
   		DataLoadFunctions.deleteAllData(); // reset database
//   		System.out.println("Testing no data in database");
//   		arguments = Arrays.asList("1", "2", "3", "4", "5").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//
   		// Missing Data
   		//
   		
   		//Data.loadFullIntegratedDataSet(0); // each course_instance is set-up to test a specific issue
   		Data.loadFullIntegratedDataSet(0);
   		
   		/*
   		 * Test using real uni scenario data, 4 students without any skills.
   		 */
   		
   		arguments = Arrays.asList("CPT331", "2015", "SP3", "Project_Focus_Simple", "60").toArray(new String[5]);
			Main.main(arguments);
			Main.main(arguments); // simulate re-run for the same course instance
   		
   		//		- no arguments passed to main
//   		System.out.println("Testing no arguments passed to main");
//			Main.main(empty_arguments);
   		
   		//		- missing students: CI_1
//   		System.out.println("Testing missing students - using course_instance 1");
//   		arguments = Arrays.asList("CPT210", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- missing projects: CI_2
//   		System.out.println("Testing missing projects - using course_instance 2");
//   		arguments = Arrays.asList("CPT220", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- project exists but no min/max data: CI_3
//   		System.out.println("Testing min/max data set to 0 - using course_instance 3");
//   		arguments = Arrays.asList("CPT230", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- project exists but no min/max data for 1 project, other project ok: CI_4
//   		System.out.println("Testing min/max data set to 0 for 1 out of 9 projects - using course_instance 4");
//   		arguments = Arrays.asList("CPT240", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   
   		
//   		DataLoadFunctions.deleteAllData(); // reset database
   		
   		//		- missing all student skills: CI_5
//   		System.out.println("Testing missing student skill data - using course_instance 5");
//   		Data.loadFullIntegratedDataSet(1);
//   		arguments = Arrays.asList("CPT250", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- missing all project skills: CI_5
//   		System.out.println("Testing missing project skill data - using course_instance 5");
//   		DataLoadFunctions.deleteAllData(); // reset database
//   		Data.loadFullIntegratedDataSet(2);
//   		arguments = Arrays.asList("CPT250", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- one project has no required skills: CI_5
//   		System.out.println("Testing missing project skill data for 1 project - using course_instance 5");
//   		DataLoadFunctions.deleteAllData(); // reset database
//   		Data.loadFullIntegratedDataSet(3);
//   		arguments = Arrays.asList("CPT250", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
//   		DataLoadFunctions.deleteAllData(); // reset database
//   		Data.loadFullIntegratedDataSet(0);
   		
   		
   		// Data Validation
   		//		- number students < sum min project size: CI_6
//   		System.out.println("Testing number students < sum min project size - using course_instance 6");
//   		arguments = Arrays.asList("CPT260", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- number students > sum max project size: CI_7
//   		System.out.println("Testing number students > sum max project size - using course_instance 7");
//   		arguments = Arrays.asList("CPT270", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		// 	- projects where min students > max students: CI_8
//   		System.out.println("Testing min students > max students - using course_instance 8");
//   		arguments = Arrays.asList("CPT280", "2015", "SP1", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		// All Data
   		
   		//		- invalid arguments passed to main
//   		System.out.println("Testing invalid arguments sent to main");
//   		arguments = Arrays.asList("1", "2050", "3", "4", "5").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- only 1 project - multiple students: CI_9
//   		System.out.println("Testing actual result with 1 project - all students assigned to project - using course_instance 9");
//   		System.out.println("Project 1- has min=3, max=7 -->> 5 students added to course_instance");
//   		arguments = Arrays.asList("CPT280", "2015", "SP9", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- only 1 project - 1 student: CI_10
//   		System.out.println("Testing actual result with 1 project - 1 student - using course_instance 10");
//   		System.out.println("Project 8- has min=1, max=1 -->> 1 students added to course_instance");
//   		arguments = Arrays.asList("CPT280", "2015", "SP10", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
			
//			- only 1 project - 1 student: CI_10_A
//   		System.out.println("Testing actual result with 1 project - 2 student (1 with skills, 1 without) - using course_instance 10");
//   		System.out.println("Project 7- has min=2, max=5 -->> 2 students added to course_instance");
//   		arguments = Arrays.asList("CPT280", "2015", "SP17", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   
   		//		- 1 project with required skill no student has: CI_11
//   		System.out.println("Testing actual result with 1 project in set have skill no student has - using course_instance 11");
//   		arguments = Arrays.asList("CPT280", "2015", "SP11", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- multiple projects with required skill no student has: CI_12
//   		System.out.println("Testing actual result with 1 project in set have skill no student has - using course_instance 12");
//   		arguments = Arrays.asList("CPT280", "2015", "SP12", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- all projects with skill weightings of 1 (lowest): CI_13
//   		System.out.println("Testing actual result with multiple projects with skill levels only of 1 - using course_instance 13");
//   		arguments = Arrays.asList("CPT280", "2015", "SP13", "Project Focus Simple", "1").toArray(new String[5]);
//   		Main.main(arguments);
   		
   		//		- multiple projects where min students = max students: CI_14
//   		System.out.println("Testing actual result with multiple projects where min students = max students - using course_instance 14");
//   		arguments = Arrays.asList("CPT280", "2015", "SP14", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
   		//		- number students = sum min projects: CI_15
//   		System.out.println("Testing actual result with multiple projects where sum min students = students - using course_instance 15");
//   		arguments = Arrays.asList("CPT280", "2015", "SP15", "Project Focus Simple", "1").toArray(new String[5]);
//			Main.main(arguments);
   		
//   				- number students = sum max projects: CI_16
   		System.out.println("Testing actual result with multiple projects where sum max students = students - using course_instance 16");
   		arguments = Arrays.asList("CPT280", "2015", "SP16", "Project_Focus_Simple", "20").toArray(new String[5]);
			Main.main(arguments);
   		
   		//		- try to rerun function of an approved function:
   		//		- not all students have skills updated flag set: CI_8
   		
   	    System.out.println("Success");
   	} catch (SQLException e)
   	{
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	}



    }

}
