package com.primary;

/**
 * Classes used for exiting the program depending on successful or not successful program run.
 */
public class ExitToWeb
{

	/**
	 * Prints a confirmation message to signal successful completion of program.
	 * Updates the database tat_course_instance table app_status field for the
	 * matched CourseInstance Id with the passed in status message. Disconnects
	 * from database and exits program normally.
	 * 
	 * @param status
	 *           - String to display
	 * @param db
	 *           - database connection object
	 * @param ld
	 *           - Data_Utilities object
	 * @param ci
	 *           - CourseInstanceIteration object
	 */
	public static void exit_on_finish(String status, DatabaseConnection db,
			Data_Utilities ld, CourseInstanceIteration ci)
	{

		// save exit type to database		
//		System.out.println("System exited normally");
//		System.out.println("Due to:  " + status);
		
		String sql = "UPDATE tat_course_instance SET "
				+ "app_status = '" + status + "' "
				+ "WHERE Id = " + ci.getInstance_id();
		ld.saveData(db, sql);
		
//		TestFunctions.testprint(ci);
		db.disconnectDatabase();
		System.exit(0);
	}

	/**
	 * Used to display an error message when program exits abnormally.
	 * Disconnects from database and exits program.
	 * 
	 * @param error
	 *           - an String to pass
	 * @param db
	 *           - database connection
	 */
	public static void exit_on_unsaveable_error(String error,
			DatabaseConnection db)
	{

		System.out.println("System exited with error -- " + error);

		db.disconnectDatabase();
		System.exit(1);
	}

}
