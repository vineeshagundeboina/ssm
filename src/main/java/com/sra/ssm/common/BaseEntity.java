package com.sra.ssm.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


    @MappedSuperclass
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class BaseEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Override
		public String toString() {
			return this.getClass().getSimpleName() + " with " + id + " ";
		}

		@Column
		private Date createdAt;

		@Column
		private Date updatedAt;

		@Column
		private String createdBy;

		@Column
		private String updatedBy;

		@Column(columnDefinition = "boolean default true")
		private Boolean isActive;

		@PrePersist
		public void onCreate() {
			this.createdAt = new Date();
			this.updatedAt = new Date();

		}

		@PreUpdate
		public void onUpdate() {
			this.updatedAt = new Date();

		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public String getUpdatedBy() {
			return updatedBy;
		}

		public void setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
		}	

	}


