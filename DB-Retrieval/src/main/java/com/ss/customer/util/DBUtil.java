package com.ss.customer.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	public static Connection getConnection(String driver, String url, String userName, String password) {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;

	}

	public static Properties loadProperties() throws Exception {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
		properties.load(fileInputStream);
		fileInputStream.close();
		return properties;
	}

	public static String getDriver() {

		String driver = null;
		try {
			driver = loadProperties().getProperty("MYSQLJDBC.driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public static String getUrl() {

		String url = null;
		try {
			url = loadProperties().getProperty("MYSQLJDBC.url");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

	public static String getUsername() {

		String userName = null;
		try {
			userName = loadProperties().getProperty("MYSQLJDBC.username");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userName;
	}

	public static String getPassword() {

		String password = null;
		try {
			password = loadProperties().getProperty("MYSQLJDBC.password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
}
