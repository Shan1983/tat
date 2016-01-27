package testing;

import java.util.ArrayList;
import java.util.Arrays;

public class Data
{

    
   public static void loadFullIntegratedDataSet(int control){
	
	String tat_user_columns = "tat_user (First_Name, Last_Name, Email, Phone_Number, GPA, Gender, Password, Access_Level, employee_number)";
	String tat_course_columns = "tat_course (Code, Title, Description)";
	String tat_course_instance_columns = "tat_course_instance (Course_Id, Year, Study_Period, Status, Facilitator, Projects_Created, Location, methodology, overall_balance, app_status)";
	String tat_project_columns = "tat_project (Title, Type, Description, Manager_Id, Status, Size_Min, Size_Max, project_difference)";
	String tat_course_project_columns = "tat_course_project (Course_Instance_Id, Project_Id)";
	String tat_course_student_columns = "tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)";
	String tat_skill_columns = "tat_skill (Name)";
	String tat_project_skill_columns = "tat_project_requirements (Project_Id, Skill_Id, Skill_Level, Weight, assigned)"; 
	String tat_user_skill_columns = "tat_user_skill (User_Id, Skill_Id, skill_level, weight)"; 
	
	
	ArrayList<ArrayList<String>> table_data = new ArrayList<ArrayList<String>>();
	// user data
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Stephen", "Nicolas", "s3395568@student.rmit.edu.au", "9999 1111", "2", "Male", "$1$T7FxzKN3$UpBv07qB4Mdg51gCiR./q1", "student", "s3395568" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Stephen", "Maynard", "s3397906@student.rmit.edu.au", "1234 1111", "2", "Male", "$1$Qj/94yBq$NcT132uMS4s9Z069HOb7o1", "student", "s3397906" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Arash", "Rostami", "s3203792@student.rmit.edu.au", "1111 9876", "2", "Male", "$1$gV7.PPiB$/LoOydWUUzw/ytH2DMH7d0", "student", "s3203792" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jakub", "Romanak", "s3413331@student.rmit.edu.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s3413331" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Shannan", "Galbraith", "s3288053@student.rmit.edu.au", "", "2", "Male", "$1$AV/p4CnE$fYWsQuHydi8/o0QLmd/Dg.", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Bradley", "Davis", "s3390039@student.rmit.edu.au", "1122 3344", "2", "Male", "$1$IY9ZG8Kc$29MHxDJ0Wgq77YtX9gL2g.", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Stephen", "Johnson", "make@gmail.com", "9999 9999", "4", "Male", "$1$wWnRaL9H$WKOGWl/y/CqafaitJmgTT.", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Michael", "Johnson", "zero@bigpond.com", "02 9513 4516", "2", "Male", "$1$rYud09Ix$nPhboxZ1xut6OfZYgcgyl1", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Mikaela", "Harley", "mk545@gmail.com", "0444 4441 0000", "3", "Female", "$1$T9nS4dQE$Cx1hxhEVs/AYlhyYv7uz50", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jessica", "Jamison", "jjjjt@gmail.com","", "3.2", "Female", "$1$StsX18jn$ZpZF7JBf2/lCR7RHoPobb/", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Bev", "Lyone", "bl23@gmail.com", "0294525439", "1.6", "Female", "$1$.uRcvcui$7LQlF1ST11/zoGkWhKmUd.", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Sam", "Ginger", "", "55548876", "3.85", "Female", "", "student", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jason", "Blake", "jblake@rmit.edu.au", "038547 1232", "0", "Male", "$1$76xdgPbc$OB8FnanB8m01KqB6YIyP7/", "lecturer", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "The", "Thing", "tt@rmit.edu.au", "", "0", "Female", "$1$WhfzQmRL$LeOpfpQZKEJy75QxHkVPu.", "lecturer", "12345" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Victoria", "Stringer", "vs@rmit.edu.au", "03 9959 9999", "0", "Female", "$1$DCwOsu0i$1KMRHKLPKITpyFMGvHD1z/", "admin", "12345" })));
	
	// course data
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT210", "Course 1", "Test Data: missing student data, all other data available" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT220", "Course 2", "Test Data: missing project data, all other data available" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT230", "Course 3", "Test Data: missing project max/min, all other data available" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT240", "Course 4", "description for course 4" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT250", "Course 5", "description for course 5" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT260", "Course 6", "description for course 6" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT270", "Course 7", "description for course 7" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT280", "Course 8", "description for course 8" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT110", "Programming 1", "Object-oriented programming using the Java programming language" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT120", "Introduction to Programming", "In this introductory unit, you will learn to think in a step-wise algorithmic fashion and relate those steps to programs that will materialise your solution on a computer system." })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT121", "Programming 1", "Object-oriented programming using the Java programming language" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_columns, "CPT999", "No Course Instance", "Testing display for no course instance" })));

	// project data -- starts at arraylist element index 27
	
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 1", "Development", "Having a go", "13", "Active", "3", "7", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 2", "Development", "Beach", "13", "Active", "2", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 3", "Development", "Sky Diving", "13", "Active", "3", "5", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 4", "Development", "Running Away", "13", "Active", "4", "6", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 5", "Development", "Jumping Sideways", "13", "Active", "4", "4", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 6", "Development", "Skipping", "13", "Active", "4", "8", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 7", "Development", "Airplane", "13", "Active", "2", "5", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 8", "Development", "Boats", "13", "Active", "1", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 9", "Special", "No Min/Max", "13", "Active", "0", "0", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Project 10", "Special", "No Min/Max", "13", "Active", "6", "3", "0" })));

	// skills -- starts at arraylist element 37
	
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "HTML"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "PHP"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Java"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Project Management"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Report Writing"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "CSS"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Python"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "C++"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Process Engineering"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Research"})));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "Coding"})));
	
	// user skills  -- starts at arraylist element 48
	
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "1", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "2", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "3", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "4", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "5", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "6", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "7", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "8", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "9", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "10", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "1", "11", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "1", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "2", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "3", "None", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "4", "None", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "5", "None", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "6", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "7", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "8", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "9", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "10", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "2", "11", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "3", "5", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "3", "6", "Intermediate", "2" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "3", "7", "Intermediate", "2" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "3", "8", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "4", "1", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "2", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "3", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "4", "None", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "5", "Intermediate", "2" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "6", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "5", "7", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "8", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "9", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "7", "10", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "1", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "1", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "7", "None", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "3", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "1", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "2", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "3", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "8", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "9", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "10", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "11", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "1", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "2", "Beginner", "1" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "3", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "4", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "6", "Expert", "3" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "7", "Intermediate", "2" })));
	
	// project skill requirements -- starts at arraylist element 101
	
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "1","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "2","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "3","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "4","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "1","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "2","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "3","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "4","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "5","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "6","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "7","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "8","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "3", "1","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "2","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "3","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "4","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "11","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "10","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "9","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "8","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "1","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "2","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "3","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "4","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "1","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "2","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "3","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "4","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "8","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "9","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "1","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "2","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "3","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "4","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "7","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "8","Temp String", "2", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "9","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "10","Temp String", "1", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "9", "1","Temp String", "3", "0" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "9", "2","Temp String", "3", "0" })));
	
	// course_instance data
	
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "1", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "2", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "3", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "4", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "5", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "6", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "7", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP1", "Active", "14", "No", "Online", "", "0", "" })));
			// instead of creating additional courses, I started changing the study period to make new course instances
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP9", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP10", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP11", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP12", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP13", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP14", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP15", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP16", "Active", "14", "No", "Online", "", "0", "" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "8", "2015", "SP17", "Active", "14", "No", "Online", "", "0", "" })));
	
	
	//
	// Creating course_instance specific data loads
	//
	
	// - missing students: CI_1
	DataLoadFunctions.createLink_Course_Project(table_data, tat_course_project_columns, "1");
	// no course_student information
	

	// - missing projects: CI_2
	// no course_project information
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "2", 12); // load all students
	
	
	// - project exists but no min/max data, all students: CI_3
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "3", "9" })));  // loading 1 project only
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "3", 12); // load all students
	
	// - project exists but no min/max data for 1 project, all students: CI_4
	DataLoadFunctions.createLink_Course_Project(table_data, tat_course_project_columns, "4"); // load projects 1 to 8
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "4", "9" }))); // load project 9
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "4", 12); // load all students
	
	// - all data exists, then remove parts as requried: CI_5
	DataLoadFunctions.createLink_Course_Project(table_data, tat_course_project_columns, "5"); // load projects 1 to 8
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "5", 12 ); // load all students
	
	if (control == 1){
		// remove all student_skills
		for (int i = 0; i < 53; i++){
			table_data.remove(48);  // remove user skills
		}
	}
	else if (control == 2){
		// remove all project_skills
		for (int i = 0; i < 40; i++){
			table_data.remove(101);  // remove user skills
		}
	}
	else if (control == 3){
		// remove project_skills for project 1 only
		for (int i = 0; i < 4; i++){
			table_data.remove(101);  // remove user skills
		}
	}
	
	// - number students < sum min project size: CI_6
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "6", "1" }))); // load project 1
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "6", "2" }))); // load project 2
		// sum min project size of projects(1 & 2) = 5 
		// therefore load 3 students
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "1", "6", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "2", "6", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "3", "6", "Yes" })));
	
	// - number students > sum max project size: CI_7
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "7", "1" }))); // load project 1
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "7", "2" }))); // load project 2
		// sum max project size of projects (1 & 2) = 10
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "7", 12); // load all students = loading 12 students

	// - min student > max student in project: CI_8
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "8", "10" }))); // load project 10
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "8", 2); // load 5 students
	
	// - only 1 project - multiple students: CI_9
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "9", "1" }))); // load project 1
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "9", 5 ); // load 5 students
	
	// - only 1 project - 1 student: CI_10
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "10", "8" }))); // load project 8
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "10", 1 ); // load 1 students
	
	// - only 1 project - 2 student: CI_10_A == CI_17
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "17", "7" }))); // load project 7
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "1", "17", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "3", "17", "Yes" })));
	
	// - 1 project with required skill no student has: CI_11
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "11", "3" }))); // load project 3
		// sum min project size of projects (3) = 3
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "8", "11", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "9", "11", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "10", "11", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "11", "11", "Yes" })));
	
	// - multiple projects with required skill no student has: CI_11
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "12", "3" }))); // load project 3
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "12", "7" }))); // load project 7
		// sum min project size of projects (3 & 7) = 5
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "4", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "6", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "7", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "8", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "9", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "10", "12", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "11", "12", "Yes" })));
	
	//	- all projects with skill weightings of 1 (lowest): CI_13
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "13", "1" }))); // load project 1
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "13", "6" }))); // load project 6
		// sum min project size of projects (1 & 6) = 7
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "1", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "4", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "6", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "7", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "8", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "9", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "10", "13", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "11", "13", "Yes" })));
	
	//	- multiple projects where min students = max students: CI_14
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "14", "5" }))); // load project 5
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "14", "8" }))); // load project 8
		// sum min project size of projects (5 & 8) = 5
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "1", "14", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "4", "14", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "6", "14", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "7", "14", "Yes" })));
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "8", "14", "Yes" })));
	
	//	- number students = sum min projects: CI_15
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "15", "1" }))); // load project 1
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "15", "2" }))); // load project 2
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "15", "3" }))); // load project 3
		// sum min project size of projects (1 & 2 & 3) = 8
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "15", 8 ); // load 8 students
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_student_columns, "10", "15", "No" })));
	
	//	- number students = sum max projects: CI_16
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "16", "2" }))); // load project 2
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "16", "5" }))); // load project 5
	table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_course_project_columns, "16", "7" }))); // load project 7
		// sum min project size of projects (2 & 5 & 7) = 12
	DataLoadFunctions.createLink_Course_Student(table_data, tat_course_student_columns, "16", 12 ); // load 12 students
	
	// CI_17 used in CI_10A
	
	
	DataLoadFunctions.addData(table_data);
   }
    
    
    
}
