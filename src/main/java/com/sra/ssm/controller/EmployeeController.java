package com.sra.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.ssm.entity.Employee;
import com.sra.ssm.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	
	@Autowired EmployeeRepo employeeRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>>getAllEmployee(){
		return ResponseEntity.ok(employeeRepo.findAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeRepo.save(employee));
		
	}

}
