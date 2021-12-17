package com.ss.procedures;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;
import com.ss.customer.util.*;

public class Procedures {
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
			String query="{call getPayRate(?,?)}";
			java.sql.CallableStatement callableStatement =connection.prepareCall(query);
			callableStatement.setString(1,employeeID );
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.execute();
			String payRate = callableStatement.getString(2);
			System.out.println(payRate);
			
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
