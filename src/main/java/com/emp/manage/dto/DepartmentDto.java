package com.emp.manage.dto;

public class DepartmentDto {
   private long id;
   private String departName;
   private String departDesc;
   
public DepartmentDto() {
	super();
}
public DepartmentDto(long id, String departName, String departDesc) {
	this.id = id;
	this.departName = departName;
	this.departDesc = departDesc;
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
   
   
}
