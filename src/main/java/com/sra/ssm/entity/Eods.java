package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Eods extends BaseEntity {
	
	private String serialNo;
    private String employeeName;
    //private List<String> tasks;
    private String tasks;
    private String status;


}
