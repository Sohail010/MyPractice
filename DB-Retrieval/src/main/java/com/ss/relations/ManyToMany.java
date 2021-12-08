package com.ss.relations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.customer.bean.UserForManyToMany;
import com.ss.customer.util.DBUtil;

public class ManyToMany {
	private String employeeId;

	public List<UserForManyToMany> getDetails(String employeeId) {
		this.employeeId = employeeId;
		Connection connection = null;
		ResultSet resultSet = null;
		ArrayList<UserForManyToMany> arrayList = new ArrayList<UserForManyToMany>();
		try {
			DBUtil.loadProperties();
			String driver = DBUtil.getDriver();
			String url = DBUtil.getUrl();
			String userName = DBUtil.getUsername();
			String password = DBUtil.getPassword();
			connection = DBUtil.getConnection(driver, url, userName, password);
			String query = "select employees.EmployeeID,projects.ProjectNum,ProjectTitle from employees RIGHT outer join projects on employees.EmployeeID=projects.EmployeeID and employees.ProjectNum=projects.ProjectNum where employees.EmployeeID='"
					+ employeeId + "';";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			// System.out.println("EmployeeID\t\tProjectNum\tProjectTitle");
			while (resultSet.next()) {
				UserForManyToMany userForManyToMany = new UserForManyToMany();
				String employeeID = resultSet.getString("EmployeeID");
				userForManyToMany.setEmployeeID(employeeID);
				String ProjectNum = resultSet.getString("ProjectNum");
				userForManyToMany.setProjectNum(ProjectNum);
				String ProjectTitle = resultSet.getString("ProjectTitle");
				userForManyToMany.setProjectTitle(ProjectTitle);
				arrayList.add(userForManyToMany);
				
			}
		} catch (Exception e) {

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
