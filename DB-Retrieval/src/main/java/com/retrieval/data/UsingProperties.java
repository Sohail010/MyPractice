package com.retrieval.data;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ss.customer.bean.User;
import com.ss.customer.util.DBUtil;

public class UsingProperties {

	public static void main(String[] args) {

		UsingProperties usingProperties = new UsingProperties();
		// usingProperties.fetchEmployeeDetails();
		String objectList = usingProperties.fetchEmployeeDetails().toString();
		System.out.println(objectList);
	}
// return user object instead of void 
//every object contains single row data

	
	public List<User> fetchEmployeeDetails() {
		Connection connection = null;
		ResultSet resultSet = null;

		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			Properties properties = DBUtil.loadProperties();
			String driver = DBUtil.getDriver();
			String url = DBUtil.getUrl();
			String userName = DBUtil.getUsername();
			String password = DBUtil.getPassword();

			connection = DBUtil.getConnection(driver, url, userName, password);
			String query = "SELECT * FROM EMP_INFO";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			System.out.println("ID\t\tFIRSTNAME\tLASTNAME\tSALARY");

			while (resultSet.next()) {
				User user = new User();
				int id = resultSet.getInt("ID");
				user.setId(id);
				String firstName = resultSet.getString("FIRSTNAME");
				user.setFirstName(firstName);
				String lastName = resultSet.getString("LASTNAME");
				user.setLastName(lastName);
				int salary = resultSet.getInt("SALARY");
				user.setSalary(salary);
				arrayList.add(user);
				// System.out.println(id + "\t\t" + firstName + "\t\t" + lastName + "\t\t" +
				// salary);
				// System.out.println(user.getId() + "\t\t" + user.getFirstName() + "\t\t" +
				// user.getLastName() + "\t\t" + user.getSalary());
			}

		} catch (Exception e) {
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
		return arrayList;
	}
}
