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

import com.sra.ssm.entity.Leaves;
import com.sra.ssm.repository.LeavesRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
@RestController
public class LeavesController {
	@Autowired LeavesRepo leavesRepo;
	
	@GetMapping("/gelAll")
	public ResponseEntity<List<Leaves>>getAllLeaves(){
		return ResponseEntity.ok(leavesRepo.findAll());
	
	}
	@PostMapping("/create")
	public ResponseEntity<Leaves>createLeaves(@RequestBody Leaves leaves){
		return ResponseEntity.ok(leavesRepo.save(leaves));
		
		
	}
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?> updateLeaves(@RequestBody Leaves leaves,@PathVariable UUID uuid) {
		
		Optional<Leaves> oldLeaves = leavesRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(leaves, oldLeaves.get());
		if (oldLeaves.isPresent()) {
			return ResponseEntity.ok(leavesRepo.save(oldLeaves.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}
	}
	@DeleteMapping("/delete/{uuid}")
	public void deleteLeaves(@PathVariable UUID uuid) {
		leavesRepo.deleteById(uuid);
		
		
	}

}
