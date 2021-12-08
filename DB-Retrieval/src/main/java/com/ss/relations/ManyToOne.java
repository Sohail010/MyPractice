package com.ss.relations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ss.customer.util.DBUtil;

public class ManyToOne {
	private String name;

	public void getOrderDetails(String name) {
		this.name = name;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			DBUtil.loadProperties();
			String driver = DBUtil.getDriver();
			String url = DBUtil.getUrl();
			String userName = DBUtil.getUsername();
			String password = DBUtil.getPassword();
			connection = DBUtil.getConnection(driver, url, userName, password);
			String query = "select customers.CustomerName, shipDate,Shipper from customers right outer join orders on (customers.CustomerID=orders.CustomerID) where CustomerName ="
					+ "'" + name + "'" + ";";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
		
			System.out.println("CustomerName\t\tshipDate\tShipper");
			while (	resultSet.next()) {
				String customerName = resultSet.getString("CustomerName");
				String shipDate = resultSet.getString("shipDate");
				String shipper = resultSet.getString("Shipper");
				System.out.println(customerName+"\t\t"+shipDate+"\t\t"+shipper);
			}
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
