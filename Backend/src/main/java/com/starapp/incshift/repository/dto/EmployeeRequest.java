package com.starapp.incshift.repository.dto;

public class EmployeeRequest {
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getApproval() {
		return approval;
	}
	public void setApproval(Integer approval) {
		this.approval = approval;
	}
	Integer employeeId;
	Integer approval;
	public EmployeeRequest(Integer employeeId, Integer approval) {
		super();
		this.employeeId = employeeId;
		this.approval = approval;
	}

	
	


}
