package com.retrieval.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieve {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/emp_data";
	private static final String USER = "root";
	private static final String PASSWORD = "sohail@2001";

	public static void main(String[] args) {

		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String query = "SELECT * FROM EMP_INFO";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

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
			e.printStackTrace();
		}
	}
}
