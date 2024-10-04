package com.emp.manage.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.manage.dto.DepartmentDto;
import com.emp.manage.exception.ResourceNotFound;
import com.emp.manage.mapper.DepartmentMapper;
import com.emp.manage.model.Department;
import com.emp.manage.repository.DepartmentRepo;
import com.emp.manage.services.DepartService;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public DepartmentDto createDepartment(DepartmentDto departmentDto) {
		
		Department department=DepartmentMapper.mapToDepartEntity(departmentDto);
		Department saveDept=departmentRepo.save(department);
		
		return DepartmentMapper.mapToDepartDto(saveDept);
	}

	@Override
	public DepartmentDto getDepartById(long id) {
		
		Department department=departmentRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFound
				("Employee is not exist with given id:" +id));
		
		return DepartmentMapper.mapToDepartDto(department);
	}

	@Override
	public List<DepartmentDto> getAllDepart() {
		List<Department> departments= departmentRepo.findAll();
		return departments.stream()
				         .map((department)->DepartmentMapper.mapToDepartDto(department))
				         .collect(Collectors.toList());
  }


	@Override
	public DepartmentDto updateDepart(long deptId, DepartmentDto updatedDept) {
		Department department=departmentRepo.findById(deptId)
				.orElseThrow(()-> new ResourceNotFound
				("Employee is not exist with given id:" +deptId));
		
		department.setDepartName(updatedDept.getDepartName());
		department.setDepartDesc(updatedDept.getDepartDesc());
		
		Department updatedDepartment=departmentRepo.save(department);
		return DepartmentMapper.mapToDepartDto(updatedDepartment);
	}

	@Override
	public void deleteDepart(long deptId) {
		departmentRepo.findById(deptId)
		.orElseThrow(()->new ResourceNotFound("Emp not exist"+ deptId));
		departmentRepo.deleteById(deptId);
	}
}
