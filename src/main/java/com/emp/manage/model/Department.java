package com.emp.manage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Department_Name")
	private String departName;
	
	@Column(name="Department_Description")
	private String departDesc;
	
	public Department(long id, String departName, String departDesc) {
		this.id = id;
		this.departName = departName;
		this.departDesc = departDesc;
	}

	public Department() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartDesc() {
		return departDesc;
	}

	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName + ", departDesc=" + departDesc + "]";
	}
	
	
}
