package com.starapp.incshift.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.starapp.incshift.repository.ProjectEmployeeMappingRepository;
@RestController
public class ProjectEmployeeMappingController {
	@Autowired
	ProjectEmployeeMappingRepository projectemployeemapping;
//	@GetMapping("/showallocation/{employeeid}")
//	public List<ProjectEmployeeMapping> fetchAllAllocation(@PathVariable("employeeid") int employeeid){
//	
//		return projectemployeemapping.findByemployeeId(employeeid);
//	}
}
