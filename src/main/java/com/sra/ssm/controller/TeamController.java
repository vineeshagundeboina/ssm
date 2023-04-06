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

import com.sra.ssm.entity.Team;
import com.sra.ssm.repository.TeamRepo;
import com.sra.ssm.service.CopyPropertiesUtil;


@RequestMapping("/api/team")
@CrossOrigin(origins = "*")
@RestController
public class TeamController {
	
@Autowired TeamRepo teamRepo;
	

	@GetMapping("/getAll")
	public ResponseEntity<List<Team>>getAllTeam(){
		return ResponseEntity.ok(teamRepo.findAll());
	}
	@PostMapping("/create")
	public ResponseEntity<Team>createTeam(@RequestBody Team team){
		return ResponseEntity.ok(teamRepo.save(team));
		
	}
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?>updateTeam(@RequestBody Team team,@PathVariable UUID uuid){
		Optional<Team> oldTeam = teamRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(team, oldTeam.get());
		if (oldTeam.isPresent()) {
			return ResponseEntity.ok(teamRepo.save(oldTeam.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteTeam(@PathVariable UUID uuid) {
		teamRepo.deleteById(uuid);
		
	}


}
