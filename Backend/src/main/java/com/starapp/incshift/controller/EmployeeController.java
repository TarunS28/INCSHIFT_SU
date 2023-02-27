package com.starapp.incshift.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.starapp.incshift.entity.Employee;

import com.starapp.incshift.repository.EmployeeRepository;
import com.starapp.incshift.repository.dto.EmployeeLogin;



@RestController
@RequestMapping("/java")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
//	@Autowired
//	private  AuthenticationManager authenticateManager;
//	 @Autowired
//	private  UserDetailsService userDetailsService;
//	 @Autowired
//	private JwtUtils jwtUtils;
	//LOGIN 
	@CrossOrigin("*")	
    @PostMapping("/login")
    public ResponseEntity<Employee> fetchEmployee(@RequestBody EmployeeLogin employeeLogin){
		System.out.println(employeeLogin.getEmployeeId());
		System.out.println(employeeRepository.findByemployeeIdAndPAssword( employeeLogin.getEmployeeId(),employeeLogin.getPassword()));
return ResponseEntity.ok(employeeRepository.findByemployeeIdAndPAssword( employeeLogin.getEmployeeId(),employeeLogin.getPassword()));
    }
	
//	 @PostMapping("/authenticate")
//	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request)
//	{ 
//		
//		 authenticateManager.authenticate(
//		new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
//		);
//	final UserDetails user=userDetailsService.loadUserByUsername(request.getEmail());
//	if(user!=null) {
//		return ResponseEntity.ok(jwtUtils.generateToken(user));
//	}
//	return ResponseEntity.status(400).body("Some error");
//	}

	
}