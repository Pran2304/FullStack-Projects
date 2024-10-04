package com.emp.manage.services;

import java.util.List;

import com.emp.manage.dto.DepartmentDto;

public interface DepartService {
	 
	DepartmentDto createDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartById(long id);

	List<DepartmentDto> getAllDepart();

	DepartmentDto updateDepart(long deptId, DepartmentDto updatedDept);

	void deleteDepart(long deptId);

}
