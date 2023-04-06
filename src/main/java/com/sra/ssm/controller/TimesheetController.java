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

import com.sra.ssm.entity.Timesheet;
import com.sra.ssm.repository.TimesheetRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class TimesheetController {
@Autowired TimesheetRepo timesheetRepo;
	

	@GetMapping("/getAll")
	public ResponseEntity<List<Timesheet>>getAllTimesheet(){
		return ResponseEntity.ok(timesheetRepo.findAll());
	}
	@PostMapping("/create")
	public ResponseEntity<Timesheet>createTimesheet(@RequestBody Timesheet timesheet){
		return ResponseEntity.ok(timesheetRepo.save(timesheet));
		
	}
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?>updateTeam(@RequestBody Timesheet timesheet,@PathVariable UUID uuid){
		Optional<Timesheet> oldTimesheet = timesheetRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(timesheet, oldTimesheet.get());
		if (oldTimesheet.isPresent()) {
			return ResponseEntity.ok(timesheetRepo.save(oldTimesheet.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteTimesheet(@PathVariable UUID uuid) {
		timesheetRepo.deleteById(uuid);
		
	}


}
