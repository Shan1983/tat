package testing;

import java.util.ArrayList;
import java.util.Arrays;

public class TestData
{
	public static void loadFullIntegratedDataSet(int control)
	{

		String tat_user_columns = "tat_user (First_Name, Last_Name, Email, Phone_Number, GPA, Gender, Password, Access_Level, employee_number)";
		String tat_course_columns = "tat_course (Code, Title, Description)";
		String tat_course_instance_columns = "tat_course_instance (Course_Id, Year, Study_Period, Status, Facilitator, Projects_Created, Location, methodology, overall_balance, app_status)";
		String tat_project_columns = "tat_project (Title, Type, Description, Manager_Id, Status, Size_Min, Size_Max, project_difference)";
		String tat_course_project_columns = "tat_course_project (Course_Instance_Id, Project_Id)";
		String tat_course_student_columns = "tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)";
		String tat_skill_columns = "tat_skill (Id, Name)";
		String tat_project_skill_columns = "tat_project_requirements (Project_Id, Skill_Id, Skill_Level, Weight, assigned)";
		String tat_user_skill_columns = "tat_user_skill (User_Id, Skill_Id, skill_level, weight)";

		ArrayList<ArrayList<String>> table_data = new ArrayList<ArrayList<String>>();
		
		// load lecturers, first 5 users
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Prem Prakash", "Jayaraman", "prem@lecturer.rmit.edu.au", "9999 1800", "0", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "lecturer", "e00001" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Andy", "Song", "andy@lecturer.rmit.edu.au", "9999 2677", "0", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "lecturer", "e00002" })));	
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Barti", "Murugesan", "barti@lecturer.rmit.edu.au", "9999 6525", "0", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "lecturer", "e00003" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Santha", "Sumanesakera", "santha@lecturer.rmit.edu.au", "9999 8977", "0", "Female", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "lecturer", "e00004" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Charles", "Thevathayan", "charlse@lecturer.rmit.edu.au", "9999 0781", "0", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "lecturer", "e00005" })));

		// load students, total 35, start index 5
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Stephen", "Nicolas", "s3395568@student.rmit.edu.au", "9999 1111", "2", "Male", "$1$T7FxzKN3$UpBv07qB4Mdg51gCiR./q1", "student", "s3395568" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Steven", "Maynard", "s3397906@student.rmit.edu.au", "1234 1111", "2", "Male", "$1$Qj/94yBq$NcT132uMS4s9Z069HOb7o1", "student", "s3397906" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Arash", "Rostami", "s3203792@student.rmit.edu.au", "1111 9876", "2", "Male", "$1$gV7.PPiB$/LoOydWUUzw/ytH2DMH7d0", "student", "s3203792" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jakub", "Romanak", "s3413331@student.rmit.edu.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s3413331" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Shannan", "Galbraith", "s3288053@student.rmit.edu.au", "", "2", "Male", "$1$AV/p4CnE$fYWsQuHydi8/o0QLmd/Dg.", "student", "s3288053" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Bradley", "Davis", "s3390039@student.rmit.edu.au", "1122 3344", "2", "Male", "$1$IY9ZG8Kc$29MHxDJ0Wgq77YtX9gL2g.", "student", "s3390039" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jay", "Kelly", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Neel", "Sahdeo", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Luke", "Herron", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Zachary", "Williamson", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Aaron", "Prince", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jeremy", "Cottell", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Anthony", "Rawlins", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Glenn", "Florence", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Ben", "Tierney", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Adriana", "Griffiths", "s12345@students.au", "9999 6525", "2", "Female", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Kevin", "Crook", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Christopher", "Yesble", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Dane", "Stephens", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Mark", "Hagemann", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "James", "Lovell", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jye", "Goodlet", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Brett", "Ayre", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Justin", "Hart", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Brad", "Francis", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Michael", "Baggott", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Jennifer", "Dousset", "s12345@students.au", "9999 6525", "2", "Female", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Duane", "McMahon", "s12345@students.au", "9999 6525", "2", "Female", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Harrison", "Slater", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Bret", "Thomas", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Alistair", "Goulding", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Luke", "Phelan", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Christopher", "Clayton", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Yiming", "Wang", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_user_columns, "Craig", "McQuinn", "s12345@students.au", "9999 6525", "2", "Male", "$1$4Q88m.Mz$gUbpfOjQse7Znh00wUiLX1", "student", "s12345" })));
		
		// load skills data, start index 41
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "1", "Java"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "2", "PHP"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "3", "HTML5"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "4", "JavaScript"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "5", "Documentation"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "6", "Project Management"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "7", "Python"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "8", "SQL"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "9", "XML"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "10", "C"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "11", "C++"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "12", "C#"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "13", ".NET"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "14", "Perl"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "15", "HTML"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "16", "CSS"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "17", "Software Engineering"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "18", "jQuery"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "19", "MVC"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "20", "cakePHP"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "21", "Bootstrap"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "22", "SCRUM"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "23", "webRTC"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "24", "Web API"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "25", "UI"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "26", "Ajax"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "27", "Git"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "28", "Apache"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "29", "Rest API"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "30", "Business Analysis"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "31", "Client Server Architecture"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "32", "Google Authentication"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "33", "Google API"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "34", "Database Development"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "35", "Information System Engineering"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "36", "Angular JS"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "37", "Yesde JS"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_skill_columns, "38", "Signlr"})));


		
		// load user skills
		//String tat_user_skill_columns = "tat_user_skill (User_Id, Skill_Id, skill_level, weight)";
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "16", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "30", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "6", "6", "Advanced", "3" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "7", "2", "Advnaced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "7", "34", "Advanced", "3" })));
	
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "25", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "15", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "16", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "8", "5", "Advanced", "3" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "1", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "9", "16", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "8", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "10", "4", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "8", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "3", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "4", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "18", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "11", "21", "Advanced", "3" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "1", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "2", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "3", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "12", "4", "Intermadiate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "13", "6", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "13", "5", "Intermadiate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "1", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "2", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "7", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "8", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "9", "Beginner", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "27", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "14", "31", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "15", "1", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "15", "3", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "15", "4", "Intermadiate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "15", "31", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "1", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "10", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "12", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "13", "Intermedaite", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "7", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "14", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "1", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "4", "Intermediate", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "15", "Intermadiate", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "16", "Intermediate", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "16", "8", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "1", "Expert", "4" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "8", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "4", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "11", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "9", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "17", "7", "Beginner", "1" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "8", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "10", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "18", "11", "Beginner", "1" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "7", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "10", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "25", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "15", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "19", "2", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "35", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "12", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "13", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "17", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "20", "22", "Beginner", "1" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "21", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "21", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "21", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "21", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "21", "8", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "20", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "13", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "12", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "21", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "18", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "19", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "9", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "7", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "22", "14", "Beginner", "1" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "1", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "2", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "11", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "13", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "19", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "23", "9", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "13", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "12", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "10", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "11", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "15", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "24", "16", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "25", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "25", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "25", "13", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "25", "4", "Beginner", "1" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "13", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "19", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "16", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "23", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "26", "7", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "38", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "13", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "12", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "16", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "24", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "38", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "19", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "27", "21", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "4", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "18", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "26", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "16", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "28", "13", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "3", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "4", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "18", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "29", "13", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "30", "13", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "30", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "30", "4", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "30", "18", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "30", "3", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "11", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "12", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "7", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "3", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "4", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "18", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "31", "13", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "13", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "10", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "11", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "12", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "1", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "7", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "14", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "32", "8", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "13", "Beginner", "1" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "24", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "15", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "16", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "18", "Advanced", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "27", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "2", "Advanced", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "21", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "33", "36", "Intermediate", "2" })));

		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "34", "1", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "34", "29", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "34", "36", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "34", "27", "Advanced", "3" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "35", "29", "Beginner", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "35", "2", "Advanced", "3" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "35", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "35", "30", "Intermediate", "2" })));
		
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "29", "Beginner", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "16", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "2", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "8", "Intermediate", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "22", "Beginner", "2" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_user_skill_columns, "36", "28", "Intermediate", "2" })));

		
		// load course data
		table_data.add(new ArrayList<String>(Arrays.asList(new String[] {
				tat_course_columns, "CPT331", "Programming Project 1",
				"This unit is designed to provide you with hands on practical experience"
						+ " developing software in a project environment. You work in teams and"
						+ " will complete projects from inception to implementation." })));
		
		// load course instance data
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_instance_columns, "1", "2015", "SP3", "Active", "1", "Yes", "Online", "", "0", "" })));

		// load project data
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Automatic Wrapper Generation for OpenIoT X-GSN", "Development", "OpenIoT is an open sourse...", "1", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Graphical Simulator", "Development", "Build visual simulator to allow...", "2", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Web/Mobile visual testbed", "Development", "Build a web-based testing environ...", "2", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Connect2Fit", "Development", "Create web based gym with live....", "3", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Team Allocation Tool", "Development", "Build web based tool which will assing in team formation...", "3", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Custom Study Plan", "Development", "The proposed project will automate...", "4", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Testing/Feedback tools for robotics", "Development", "Build a web based tool where students...", "5", "Active", "4", "6", "0" })));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_project_columns, "Timesheet Tool", "Development", "Build a cloud based timesheet tool...", "3", "Active", "2", "4", "0" })));
		
		// load course instanace / project association
		// String tat_course_project_columns = "tat_course_project (Course_Instance_Id, Project_Id)";
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "1"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "2"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "3"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "4"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "5"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "6"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "7"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_project_columns, "1", "8"})));
		
	// load project skills 
			//String tat_project_skill_columns = "tat_project_requirements (Project_Id, Skill_Id, Skill_Level, Weight, assigned)";
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "1","Advanced", "3", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "3","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "4","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "31","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "7","Beginner", "1", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "1", "2","Beginner", "1", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "11","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "16","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "2", "9","Intermediate", "1", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "3", "12","Advanced", "3", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "3", "17","Intermediate", "1", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "3", "3","Intermediate", "1", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "3", "8","Intermediate", "1", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "4","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "4", "25","Intermediate", "2", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "1","Intermedaite", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "2","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "34","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "3","Beginner", "1", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "5", "25","Intermediate", "1", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "1","Advanced", "3", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "17","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "7", "19","Intermediate", "1", "2" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "28","Advanced", "3", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "32","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "6", "33","Intermediate", "2", "0" })));
			
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "24","Advanced", "3", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "33","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "15","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "2","Intermediate", "2", "0" })));
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {tat_project_skill_columns, "8", "8","Intermediate", "2", "0" })));
			
		
		// load student to course instance
		//String tat_course_student_columns = "tat_course_student (User_Id, Course_Instance_Id, Skills_Updated)";
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "6", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "7", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "8", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "9", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "10", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "11", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "12", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "13", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "14", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "15", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "16", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "17", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "18", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "19", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "20", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "21", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "22", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "23", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "24", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "25", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "26", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "27", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "28", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "29", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "30", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "31", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "32", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "34", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "35", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "36", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "37", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "38", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "39", "1", "Yes"})));
		table_data.add(new ArrayList<String>(Arrays.asList(new String[]{tat_course_student_columns, "40", "1", "Yes"})));


		DataLoadFunctions.addData(table_data);
		

	} // end of loadFullIntergratedDataSet function

}
