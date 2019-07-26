package com.dustyfingers.CarMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int audit_id;
	@Column(name = "date_created")
	private String date_created;
	@Column(name = "deleted")
	private boolean deleted;
	@Column(name = "created_by")
	private String created_by; // I assume this to be a string
	@Column(name = "description")
	private String description;
	//@ForeignKey
	//private int car_id; //foreign key
	
	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;
	
	public Audit() {
		super();
	}


	public Audit(int audit_id, String date_created, boolean deleted, String created_by, String description) {
		super();
		this.audit_id = audit_id;
		this.date_created = date_created;
		this.deleted = deleted;
		this.created_by = created_by;
		this.description = description;
	}


	public int getAudit_id() {
		return audit_id;
	}

	public void setAudit_id(int audit_id) {
		this.audit_id = audit_id;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
