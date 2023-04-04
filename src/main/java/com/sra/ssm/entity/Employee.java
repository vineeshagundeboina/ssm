package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Employee extends BaseEntity{
	
    private String employeeName;
    private String employeeId;
    private String employeeEmail;
    private String employeePhone;
    private String employeeAddress;
    private String employeePosition;
    private String employeeExperience;
    private EmployeeType employeeType;
    private EmployeeBelongs employeeBelongs;


}
