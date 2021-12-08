package com.ss.relations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.ss.customer.util.*;

public class OnetoOne {
	private String name;

	public void getPayRate(String name) {
		this.name = name;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			Properties properties = DBUtil.loadProperties();
			String Driver = DBUtil.getDriver();
			String url = DBUtil.getUrl();
			String userName = DBUtil.getUsername();
			String password = DBUtil.getPassword();
			connection = DBUtil.getConnection(Driver, url, userName, password);
			String query = "SELECT personal.EmployeeID,payRate from personal right outer join payroll on (personal.EmployeeID=payroll.EmployeeID) where FirstName ="
					+ "'" + name + "'" + ";";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			// String employeeID = resultSet.getString("EmployeeID");
			String payRate = resultSet.getString("PayRate");
			System.out.println("PayRate of " + name + " per hour is: " + payRate);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
