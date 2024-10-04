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

import com.emp.manage.dto.DepartmentDto;
import com.emp.manage.services.DepartService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/departments")
public class DepartController {
    @Autowired
	private DepartService departService;
	
	@PostMapping("add")
	public DepartmentDto addDepart(@RequestBody DepartmentDto departmentDto) {
		return departService.createDepartment(departmentDto);
	}
    
	@GetMapping("{DeptId}")
	public DepartmentDto getDeptById(@PathVariable long DeptId) {
		return departService.getDepartById(DeptId);
	}
    
	@GetMapping()
	public List<DepartmentDto> getAllDept(){
		return departService.getAllDepart();
	}
	
	@PutMapping("/update/{DeptId}")
	public DepartmentDto updateDept(@PathVariable long DeptId,@RequestBody DepartmentDto updatedDept) {
		return departService.updateDepart(DeptId,updatedDept);
	}
	
	@DeleteMapping("/delete/{DeptId}")
	public void deleteDept(@PathVariable long DeptId) {
		departService.deleteDepart(DeptId);
	}
	}
