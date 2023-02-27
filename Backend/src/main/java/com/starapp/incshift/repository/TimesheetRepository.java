package com.starapp.incshift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.starapp.incshift.entity.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet,String>{
	@Query("select t from Timesheet t  where t.project.Projectid in(SELECT c.Projectid from Project c where c.employee.Employeeid=?1) ")
	List<Timesheet> findAllTimesheet(int Employeeid);
    
	
	@Query("select t from Timesheet t where t.employee.Employeeid=?1  ")
	List<Timesheet> findByemployeeId(int Employeeid);
  
	@Query("select t from Timesheet t where t.employee.Employeeid!=?1 and t.project.Projectid=?2  ")
	List<Timesheet> findByemployeeId(int Employeeid,String Projectid);
	
	@Query("select t from Timesheet t where t.employee.Employeeid=?1 and t.Approval=?2  ")
	List<Timesheet> findByemployeeIdapproval(int Employeeid,int Approval);
    Timesheet findBytimesheetId(String timesheetid);
    
    
}
