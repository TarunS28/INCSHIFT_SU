package com.starapp.incshift.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.starapp.incshift.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
//	@Query("SELECT c.Projectid from Project c ")
//	List<String> findAllUsers();
//	
//
//@Query("SELECT c.Projectid from Project c where c.employee.Employeeid=?1 ")
//
//@Query("select t.timesheetId from Timesheet t where t.project.Projectid in(SELECT c.Projectid from Project c where c.employee.Employeeid=?1) ")
	
    @Query("SELECT e from Employee e where e.Employeeid=?1 and e.Password=?2 ")
	Employee findByemployeeIdAndPAssword(int employeeId,String Password);

}



