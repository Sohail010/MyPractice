package com.retrieval.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class RetrievalData {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/emp_data";
	private static final String USER = "root";
	private static final String PASSWORD = "sohail@2001";

	static Connection connection = null;
	public static Connection connectDB() throws Exception {

		Class.forName(DRIVER);
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}

	public static void main(String[] args) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String query = "SELECT * FROM EMP_INFO";
		try {
			connection = RetrievalData.connectDB();

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			System.out.println("ID\t\tFIRSTNAME\tLASTNAME\tSALARY");
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String firstName = resultSet.getString("FIRSTNAME");
				String lastName = resultSet.getString("LASTNAME");
				int salary = resultSet.getInt("SALARY");
				System.out.println(id + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + salary);
			}
			connection.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
