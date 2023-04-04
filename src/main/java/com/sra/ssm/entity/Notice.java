package com.sra.ssm.entity;

import javax.persistence.Entity;

import com.sra.ssm.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notice extends BaseEntity {

	private String noticeName;
    private String noticeTitle;
    private String noticeDescription;
    private String noticeDate;
    private String noticeAttachment;

}
