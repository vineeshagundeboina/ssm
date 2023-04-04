package com.sra.ssm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sra.ssm.entity.Notice;

@Repository
public interface NoticeRepo extends JpaRepository<Notice, UUID>{

}
