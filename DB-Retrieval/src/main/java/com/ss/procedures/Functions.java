package com.ss.procedures;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.ss.customer.util.DBUtil;

public class Functions {
	private String employeeID;
	Connection connection = null;

	public void getPayRate(String employeeID) {
		this.employeeID = employeeID;
		
		String driver = DBUtil.getDriver();
		String url = DBUtil.getUrl();
		String userName = DBUtil.getUsername();
		String password = DBUtil.getPassword();
		try {
			DBUtil.loadProperties();
			connection = DBUtil.getConnection(driver, url, userName, password);
			String query="{?=call payRate_function(?)}";
			java.sql.CallableStatement callableStatement =connection.prepareCall(query);
			callableStatement.setString(2,employeeID );
			callableStatement.registerOutParameter(1, Types.VARCHAR);
			callableStatement.execute();
			
			String payRate = callableStatement.getString(1);
			System.out.println("The payrate of "+employeeID+" is: "+payRate);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

	}

}
