package com.sra.ssm.common;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;


    @MappedSuperclass
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class BaseEntity {
		
    	@Id
    	@GeneratedValue(generator = "UUID")
    	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
    			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
    	// @Type(type = "pg-uuid")
    	@org.hibernate.annotations.Type(type = "uuid-char")
    	private UUID id;
		
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

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
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


