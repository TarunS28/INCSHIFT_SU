package com.starapp.incshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starapp.incshift.dto.ManagerRequest;

import com.starapp.incshift.entity.Timesheet;

import com.starapp.incshift.repository.TimesheetRepository;

import com.starapp.incshift.repository.dto.EmployeeRequest;

@RestController
public class TimesheetController {
	
	@Autowired
	TimesheetRepository timesheetRepository;
	
	//showalltimesheetto manager
	@CrossOrigin("*")
	@GetMapping("/java/showtimesheettomanager/{managerid}")
	public List<Timesheet> fetchAlltimesheet(@PathVariable("managerid") int managerid){
	  
		return timesheetRepository.findAllTimesheet(managerid);
	}
	//update status of timesheet of employee by manager	
	@CrossOrigin("*")
	@PatchMapping("/java/Manager/Timesheet/Approve/{timesheetid}")
	public Timesheet updatestatus(@PathVariable String timesheetid) {
		Timesheet timesheet = timesheetRepository.findBytimesheetId(timesheetid);
		timesheet.setApproval(1);
	
		return timesheetRepository.save(timesheet);
		
	}

	//showtimesheetbasedonprojectid
	@CrossOrigin("*")	
	@GetMapping("/java/showtimesheettomanagerprojectwise/{managerid}/{projectid}")
	public List<Timesheet> fetchAlltimesheetOfUserBasedOnProjectId(@PathVariable("managerid") int employeeid,@PathVariable("projectid") String projectid){
		
		return timesheetRepository.findByemployeeId(employeeid,projectid);
	}
	
	//show all timesheet to manager
	@CrossOrigin("*")	
	@GetMapping("/java/Manager/Timesheet/{employeeid}")
	public List<Timesheet> fetchAlltimesheetOfUser(@PathVariable("employeeid") int employeeid){
	
		return timesheetRepository.findByemployeeId(employeeid);
	}
	
	//show all timesheet to employee based on aprroval status 1-approved and 0-rejected
	@CrossOrigin("*")	
	@GetMapping("/java/showtimesheettoemployee/{employeeid}/{approval}")
	public List<Timesheet> fetchAlltimesheetOfUser(@PathVariable("employeeid") int employeeid,@PathVariable("approval")int approval){
	
		return timesheetRepository.findByemployeeIdapproval(employeeid,approval);
	}
	@CrossOrigin("*")
	 @PostMapping("java/Employee/Timesheet/approved")
	    public ResponseEntity<List<Timesheet>> fetchEmployee(@RequestBody EmployeeRequest employeeRequest){


	return ResponseEntity.ok(timesheetRepository.findByemployeeIdapproval( employeeRequest.getEmployeeId(),employeeRequest.getApproval()));
	    }
	
//	@CrossOrigin("*")	
//	@GetMapping("java/Employee/Timesheet/approved/{employeeid}/{approval}")
//	public List<Timesheet> fetchAlltimesheet(@PathVariable("employeeid") int employeeid,@PathVariable("approval")int approval){
//	System.out.println(employeeid);
//	System.out.println(approval);
//		return timesheetRepository.findByemployeeIdapproval(employeeid,approval);
//	}
	
	//jugad..........
	@CrossOrigin("*")	
	@PostMapping("/java/Manager/Timesheet")
	public ResponseEntity<List<Timesheet>> fetchAlltimesheetOfManager(@RequestBody EmployeeRequest employeeRequest ){
		System.out.println(employeeRequest.getEmployeeId());
		return ResponseEntity.ok(timesheetRepository.findByemployeeId(employeeRequest.getEmployeeId()));
	}	
	//jugad
	@CrossOrigin("*")	
	@PostMapping("/java/Manager/Timesheet/Project")
	public ResponseEntity<List<Timesheet>> fetchAlltimesheetTOManagerBasedOnProjectId(@RequestBody ManagerRequest managerRequest){
		
		return ResponseEntity.ok(timesheetRepository.findByemployeeId(managerRequest.getEmployeeId(),managerRequest.getProjectId()));
	}
	
//	//update status of timesheet of employee by manager
//		@PatchMapping("/java/Manager/Timesheet/Approve")
//		public ResponseEntity<Timesheet> updatestatuss(@RequestBody TimesheetUpdateRequest timesheetUpdateRequest) {
//			System.out.println(timesheetUpdateRequest.getTimesheetId());
//			Timesheet timesheet = timesheetRepository.findBytimesheetId(timesheetUpdateRequest.getTimesheetId());
//			timesheet.setApproval(1);
//		
//			return ResponseEntity.ok(timesheetRepository.save(timesheet));
//			
//		}
	
}
