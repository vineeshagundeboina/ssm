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

import com.sra.ssm.entity.Eods;
import com.sra.ssm.repository.EodsRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

	@RestController
	@RequestMapping("/api/eods")
	@CrossOrigin(origins = "*")
	public class EodsController {
		
		@Autowired EodsRepo eodsRepo;
		
		@GetMapping("/getAll")
		public ResponseEntity<List<Eods>>getAllEods(){
			return ResponseEntity.ok(eodsRepo.findAll());
		}
		
		@PostMapping("/create")
		public ResponseEntity<Eods>createEods(@RequestBody Eods eods){
			return ResponseEntity.ok(eodsRepo.save(eods));
		}
	    
		
		@PutMapping("/update/{uuid}")
		public ResponseEntity<?> updateEods(@RequestBody Eods eods,@PathVariable UUID uuid) {
			
			Optional<Eods> oldEods = eodsRepo.findById(uuid);
			CopyPropertiesUtil.copyProperties(eods, oldEods.get());
			if (oldEods.isPresent()) {
				return ResponseEntity.ok(eodsRepo.save(oldEods.get()));
			} else {
				return ResponseEntity.ok("innvalid ID");
			}

		}
		@DeleteMapping("/delete/{uuid}")
		public void deleteEods(@PathVariable UUID uuid) {
			//Academics academic = academicsRepo.findById(acadamicsId).get();
			eodsRepo.deleteById(uuid);
			///return ResponseEntity.ok(academic);
			// delete from acadamics where acadamic id="?";
		}

			

			
		}





