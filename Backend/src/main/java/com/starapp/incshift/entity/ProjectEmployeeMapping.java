package com.starapp.incshift.entity;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity

public class ProjectEmployeeMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="Employeeid")
    Employee employee;
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="Projectid")
    Project project ;
	 int Allocation;
	 ProjectEmployeeMapping(){
		 
	 }
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getAllocation() {
		return Allocation;
	}
	public void setAllocation(int allocation) {
		Allocation = allocation;
	}
	public ProjectEmployeeMapping(int id, Employee employee, Project project, int allocation) {
		super();
		Id = id;
		this.employee = employee;
		this.project = project;
		Allocation = allocation;
	}
	@Override
	public String toString() {
		return "ProjectEmployeeMapping [Id=" + Id + ", employee=" + employee + ", project=" + project + ", Allocation="
				+ Allocation + "]";
	}
	 
}
