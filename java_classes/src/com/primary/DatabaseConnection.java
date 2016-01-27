package com.primary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * SUPER IMPORTANT!! if you can not access the database on your machine please
 * make sure that 1. the below is correct i.e. check the url string, username,
 * passwords etc 2. you have added the mysql connector to the classpath you can
 * d/l the mysql connector from here:
 * http://dev.mysql.com/downloads/connector/j/ once the download is completed,
 * right click on project click on build path, configure build path then chose
 * the library tab and then add external library jar file. if you have any
 * problems don't hesitate to ask :)
 *
 */

public class DatabaseConnection
{

	// field/members for database config
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/tat";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "ChocolateMilkIsDelicious2015";
	// private static final String PASSWORD = "root";
   //	private static final String PASSWORD = "";

	// connection
	private Connection conn;

	// properties
	private Properties props;

	// make the properties
	private Properties getProps()
	{
		if (this.props == null)
		{
			this.props = new Properties();
			props.setProperty("user", USERNAME);
			props.setProperty("password", PASSWORD);
		}
		return props;
	}

	/**
	 * Established a connection to the specified database.
	 * 
	 * @return a Connection object
	 */
	public Connection connect()
	{
		if (this.conn == null)
		{
			try
			{
				Class.forName(DATABASE_DRIVER);
				conn = DriverManager.getConnection(DATABASE_URL, getProps());
			} catch (ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * Ends the connection to the database.
	 */
	public void disconnectDatabase()
	{
		if (this.conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
