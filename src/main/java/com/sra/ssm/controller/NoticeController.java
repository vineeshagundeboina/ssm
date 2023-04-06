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

import com.sra.ssm.entity.Notice;
import com.sra.ssm.repository.NoticeRepo;
import com.sra.ssm.service.CopyPropertiesUtil;

@RestController
@RequestMapping("/api/notice")
@CrossOrigin(origins = "*")
public class NoticeController {
	
	@Autowired NoticeRepo noticeRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Notice>>getAllNotice(){
		return ResponseEntity.ok(noticeRepo.findAll());
	}
	@PostMapping("/create")
	public ResponseEntity<Notice>createNotice(@RequestBody Notice notice){
		return ResponseEntity.ok(noticeRepo.save(notice));
		
	}
	
	@PutMapping("/update/{uuid}")
	public ResponseEntity<?>updateNotice(@RequestBody Notice notice,@PathVariable UUID uuid){
		java.util.Optional<Notice> oldNotice = noticeRepo.findById(uuid);
		CopyPropertiesUtil.copyProperties(notice, oldNotice.get());
		if (oldNotice.isPresent()) {
			return ResponseEntity.ok(noticeRepo.save(oldNotice.get()));
		} else {
			return ResponseEntity.ok("innvalid ID");
		}
	}
	
	@DeleteMapping("/delete/{uuid}")
	public void deleteNotice(@PathVariable UUID uuid) {
		noticeRepo.deleteById(uuid);
		
	}
}
