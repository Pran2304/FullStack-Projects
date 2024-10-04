package com.emp.manage.dto;


public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private long deptId; 
	
	public EmployeeDto(int id, String firstName, String lastName, String email ,long deptId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.deptId=deptId;
	}
	public EmployeeDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", deptId=" + deptId + "]";
	}
	
	
	
}
