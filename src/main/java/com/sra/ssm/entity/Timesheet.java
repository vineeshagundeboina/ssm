package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Timesheet extends BaseEntity{
	
    private String projectName;
    private String taskName;
    private String date;
    private String startTime;
    private String endTime;
    private String totalHours;


}
