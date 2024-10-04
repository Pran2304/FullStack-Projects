package com.emp.manage.services;

import java.util.List;

import com.emp.manage.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto emplyoyeeDto);
	
	EmployeeDto getEmployee(int id);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(int empId,EmployeeDto updatedEmp);
	
	void deleteEmp(int empId);
}
