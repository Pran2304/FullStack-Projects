package com.emp.manage.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.manage.dto.EmployeeDto;
import com.emp.manage.exception.ResourceNotFound;
import com.emp.manage.mapper.EmployeeMapper;
import com.emp.manage.model.Employee;
import com.emp.manage.repository.DepartmentRepo;
import com.emp.manage.repository.EmployeeRepository;
import com.emp.manage.services.EmployeeService;
import com.emp.manage.model.Department;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee =EmployeeMapper.mapToEmployee(employeeDto);
		Department department=departmentRepo.findById(employeeDto.getDeptId())
				.orElseThrow(()->
				new ResourceNotFound("Department is not exists with id: " + employeeDto.getDeptId()));
		
		employee.setDepartment(department);
		Employee savedEmp= employeeRepo.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmp);
	}
	
	@Override
	public EmployeeDto getEmployee(int id) {
		
		Employee detailEmp= employeeRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFound
						("Employee is not exist with given id:" +id));
		return EmployeeMapper.mapToEmployeeDto(detailEmp);
	}
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees= employeeRepo.findAll();
		
		return employees.stream()
				.map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(int empId, EmployeeDto updatedEmp) {
	
	Employee employee = employeeRepo.findById(empId)
			.orElseThrow(()->new ResourceNotFound("Emp not exist"+ empId));
		
	     employee.setFirstName(updatedEmp.getFirstName());
	     employee.setLastName(updatedEmp.getLastName());
	     employee.setEmail(updatedEmp.getEmail());  
	     
	     
	     Department department=departmentRepo.findById(updatedEmp.getDeptId())
					.orElseThrow(()->
					new ResourceNotFound("Department is not exists with id: " + updatedEmp.getDeptId()));
			
			employee.setDepartment(department);
			
			
         Employee updateEmp = employeeRepo.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updateEmp);
	}

	@Override
	public void deleteEmp(int empId) {
		employeeRepo.findById(empId)
				.orElseThrow(()->new ResourceNotFound("Emp not exist"+ empId));
		employeeRepo.deleteById(empId);
		
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepo, DepartmentRepo departmentRepo) {
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
	}

	public EmployeeServiceImpl() {
	}
	
	
	
		
}
