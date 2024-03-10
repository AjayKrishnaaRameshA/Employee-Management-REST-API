package com.employee.restapi.service;

import java.util.List;

import com.employee.restapi.dto.EmployeeDto;
import com.employee.restapi.entity.Employee;

public interface EmployeeService {
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto save(EmployeeDto dto);
	
	EmployeeDto getEmployeeById(Long id);
	
	EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee);
	
	void deleteById(Long id);
}
