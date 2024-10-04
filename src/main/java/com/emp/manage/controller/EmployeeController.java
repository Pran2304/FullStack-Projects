package com.emp.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.manage.dto.EmployeeDto;
import com.emp.manage.services.EmployeeService;




@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/add")
	public EmployeeDto addEmp(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto);
		
	}
	
	@GetMapping("{empId}")
	public EmployeeDto getEmp(@PathVariable int empId){
		return employeeService.getEmployee(empId);
	}
	
	@GetMapping
	public List<EmployeeDto> getAllEmp(){
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("{empId}")
	public EmployeeDto updateEmployee(@PathVariable int empId,@RequestBody EmployeeDto updatedEmp) {
		return employeeService.updateEmployee(empId, updatedEmp);
	}
	@DeleteMapping("{empId}")
	public String deleteEmp(@PathVariable int empId) {
		employeeService.deleteEmp(empId);
		return ("Employee deleted with Id"+empId);
	}
}
