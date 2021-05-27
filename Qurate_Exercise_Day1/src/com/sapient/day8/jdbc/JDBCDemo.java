package com.sapient.day8.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	private static Connection con = null;
	private static Statement statement = null;

	private static ResultSet resultSet = null;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				// 1. create a connection to MySQL DB // demo schema
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "Abc10abc");

				// 2. issue SQL queries to database
				statement = con.createStatement();

				// 3. save the response in result set
				resultSet = statement.executeQuery("select * from demo.customers where id =2 ");

				writeResultSet(resultSet);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			System.out.println("Inside finally - closeDB() called");
			closeDB();
		}

	} // main ends

	private static void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set

		while (resultSet.next()) {

			int id = resultSet.getInt("id");
			String city = resultSet.getString("city");
			String name = resultSet.getString("name");

			System.out.println("ID: " + id);
			System.out.println("City: " + city);
			System.out.println("Name: " + name);
			System.out.println(" --------------- ");

		}
	}

	public static void closeDB() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {

		}
	}
}
