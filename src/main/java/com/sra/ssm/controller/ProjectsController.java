package com.sra.ssm.controller;
import java.util.List;
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

import com.sra.ssm.entity.Projects;
import com.sra.ssm.repository.ProjectsRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectsController {
	
	@Autowired ProjectsRepo projectsRepo;
	

	@GetMapping("/getAll")
	public ResponseEntity<List<Projects>>getAllProjects(){
		return ResponseEntity.ok(projectsRepo.findAll());
	}
	@PostMapping("/create")
	public ResponseEntity<Projects>createProjects(@RequestBody Projects projects){
		return ResponseEntity.ok(projectsRepo.save(projects));
		
	}
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?>updateProjects(@RequestBody Projects projects,@PathVariable UUID uuid){
		java.util.Optional<Projects> oldProjects = projectsRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(projects, oldProjects.get());
		if (oldProjects.isPresent()) {
			return ResponseEntity.ok(projectsRepo.save(oldProjects.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteProjects(@PathVariable UUID uuid) {
		projectsRepo.deleteById(uuid);
		
	}

}
