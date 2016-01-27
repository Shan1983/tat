package testing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;


import com.primary.DatabaseConnection;

public class DataLoadFunctions
{

	// delete all data from database

	@SuppressWarnings("unused")
	public static void deleteAllData() throws SQLException
	{

		Statement statement;
		Statement s1 = null;
		DatabaseConnection db = null;

		try
		{
			db = new DatabaseConnection();
			String sql = "SELECT Concat('TRUNCATE TABLE ', table_schema, '.', TABLE_NAME, ';')"
					+ "FROM INFORMATION_SCHEMA.TABLES where table_schema in ('tat');";

			s1 = db.connect().createStatement();
			ResultSet r = s1.executeQuery("SET FOREIGN_KEY_CHECKS=0;");

			statement = db.connect().createStatement();
			ResultSet results = statement.executeQuery(sql);

			while (results.next())
			{
				String sql_2 = results.getString(1);
				Statement s2 = db.connect().createStatement();
				s2.executeUpdate(sql_2);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			ResultSet r = s1.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
			db.disconnectDatabase();
		}
	}

	// add data to database

	public static void addData(ArrayList<ArrayList<String>> table_data)
	{

		DatabaseConnection db = null;

		try
		{

			db = new DatabaseConnection();
			for (ArrayList<String> al : table_data)
			{

				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO tat.").append(al.get(0))
						.append(" VALUES (");

				for (int i = 1; i < al.size(); i++)
				{
					sql.append("'").append(al.get(i)).append("'");
					if (i < al.size() - 1)
					{
						sql.append(", ");
					} else
					{
						sql.append(")");
					}
				}
//				System.out.println(sql);
				Statement statement = db.connect().createStatement();
				statement.executeUpdate(sql.toString());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			db.disconnectDatabase();
		}
	}

	// create all data

	public static void createAllData(ArrayList<ArrayList<String>> table_data)
	{

	}

	// create link between course and project

	public static void createLink_Course_Project(
			ArrayList<ArrayList<String>> table_data, String column_names, String ci)
	{

		// projects go from 1 to 8

		for (int i = 1; i <= 8; i++)
		{
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {
					column_names, ci, Integer.toString(i) })));
		}
	}

	// create link between course and student

	public static void createLink_Course_Student(
			ArrayList<ArrayList<String>> table_data, String column_names, String ci, int max_number_students)
	{

		// students go from 1 to 12

		for (int i = 1; i <= max_number_students; i++)
		{
			table_data.add(new ArrayList<String>(Arrays.asList(new String[] {
					column_names, Integer.toString(i), ci, "Yes" })));
		}
	}

}
