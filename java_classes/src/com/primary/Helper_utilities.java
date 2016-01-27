package com.primary;

import java.sql.SQLException;

public class Helper_utilities
{
	public static void print_error_message(SQLException e) {
		System.out.println(e.getMessage() + "\nCause: " + e.getCause()
		+ "\nError Code: " + e.getErrorCode() + "\nSQL State: " + e.getSQLState());
	}
	
	public static boolean isInteger(String s){
		return s.matches("\\d*");
	}
	
}
