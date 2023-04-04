package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Projects extends BaseEntity {
	
	private String projectName;
    private String projectTech;
    private String projectDescription;
    private String projectStartTime;
    private String projectEndTime;
    private String projectOwner;


}
