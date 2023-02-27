package com.starapp.incshift.repository.dto;

public class EmployeeLogin {
	Integer employeeId;
	String password;

	public EmployeeLogin(Integer employeeId, String password) {
		super();
		this.employeeId = employeeId;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}
