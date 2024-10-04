package com.emp.manage.mapper;

import com.emp.manage.dto.DepartmentDto;
import com.emp.manage.model.Department;

public class DepartmentMapper {
   
	public static DepartmentDto mapToDepartDto(Department department) {
		return new DepartmentDto(
				department.getId(),
				department.getDepartName(),
				department.getDepartDesc()
				);
	}
	
	
	public static Department mapToDepartEntity(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(),
				departmentDto.getDepartName(),
				departmentDto.getDepartDesc()
				);
	}
}
