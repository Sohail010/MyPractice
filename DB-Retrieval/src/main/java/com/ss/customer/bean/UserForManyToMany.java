package com.ss.customer.bean;

public class UserForManyToMany {
	private String employeeID;
	private String projectNum;
	private String projectTitle;

	public String getEmployeeID() {
		return employeeID;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String toString() {
		return "{"+employeeID + ","+projectNum+","+projectTitle+"}";
		
	}

}
