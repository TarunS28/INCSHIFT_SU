package com.starapp.incshift.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Timesheet {
	@Id
	String timesheetId;
	String startDate;
	String endDate;
	int Hours;
	int Approval;
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="Projectid")
    Project project ;
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="Employeeid")
    Employee employee ;

	@OneToOne
	ProjectEmployeeMapping projectemployeemapping;
	Timesheet(){
		
	}
	public String getTimesheetId() {
		return timesheetId;
	}
	public void setTimesheetId(String timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getTimesheet_Id() {
		return timesheetId;
	}
	public void setTimesheet_Id(String timesheetId) {
		this.timesheetId = timesheetId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getHours() {
		return Hours;
	}
	public void setHours(int hours) {
		Hours = hours;
	}
	public int getApproval() {
		return Approval;
	}
	public void setApproval(int approval) {
		Approval = approval;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public ProjectEmployeeMapping getProjectemployeemapping() {
		return projectemployeemapping;
	}
	public void setProjectemployeemapping(ProjectEmployeeMapping projectemployeemapping) {
		this.projectemployeemapping = projectemployeemapping;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Timesheet(String timesheetId, String startDate, String endDate, int hours, int approval, Project project,
			Employee employee, ProjectEmployeeMapping projectemployeemapping) {
		super();
		this.timesheetId = timesheetId;
		this.startDate = startDate;
		this.endDate = endDate;
		Hours = hours;
		Approval = approval;
		this.project = project;
		this.employee = employee;
		this.projectemployeemapping = projectemployeemapping;
	}
	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", Hours=" + Hours + ", Approval=" + Approval + ", project=" + project + ", employee=" + employee
				+ ", projectemployeemapping=" + projectemployeemapping + "]";
	}

	
}
