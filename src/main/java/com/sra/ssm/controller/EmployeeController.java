package com.sra.ssm.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.ssm.entity.Employee;
import com.sra.ssm.repository.EmployeeRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

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
    
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee,@PathVariable UUID uuid) {
		
		Optional<Employee> oldEmployee = employeeRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(employee, oldEmployee.get());
		if (oldEmployee.isPresent()) {
			return ResponseEntity.ok(employeeRepo.save(oldEmployee.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}

	}
	@DeleteMapping("/delete/{uuid}")
	public void deleteEmployee(@PathVariable UUID uuid) {
		//Academics academic = academicsRepo.findById(acadamicsId).get();
		employeeRepo.deleteById(uuid);
		///return ResponseEntity.ok(academic);
		// delete from acadamics where acadamic id="?";
	}

		

		
	}


