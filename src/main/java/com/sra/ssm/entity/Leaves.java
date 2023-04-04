package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Leaves extends BaseEntity{
	
    private String employeeName;
    private String employeeId;
    private String employeeEmail;
    private String employeePhone;
    private String managerEmail;
    private String leaveStart;
    private String leaveEnd;
    private LeaveType leavetype;
    
        
}
