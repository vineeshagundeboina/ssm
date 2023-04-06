package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Team extends BaseEntity{
	
	private String employees;
	private String management;
	

}
