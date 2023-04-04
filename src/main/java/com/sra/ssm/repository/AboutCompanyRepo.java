package com.sra.ssm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sra.ssm.entity.AboutCompany;
@Repository
public interface AboutCompanyRepo extends JpaRepository<AboutCompany,UUID>{

}
