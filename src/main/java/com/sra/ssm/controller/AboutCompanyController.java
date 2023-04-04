package com.sra.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sra.ssm.entity.AboutCompany;
import com.sra.ssm.repository.AboutCompanyRepo;

@RestController
@RequestMapping("/api/aboutcompany")
@CrossOrigin(origins = "*")
public class AboutCompanyController {
	
	@Autowired AboutCompanyRepo aboutCompanyRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<AboutCompany>>getAllAboutCompany(){
		try {
			return ResponseEntity.ok(aboutCompanyRepo.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/create")
	public ResponseEntity<AboutCompany>createAboutCompany(@RequestBody AboutCompany aboutCompany){
		return ResponseEntity.ok(aboutCompanyRepo.save(aboutCompany));

	}
	

}
