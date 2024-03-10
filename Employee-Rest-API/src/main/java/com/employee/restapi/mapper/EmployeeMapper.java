package com.employee.restapi.mapper;

import com.employee.restapi.dto.EmployeeDto;
import com.employee.restapi.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapEmployeeToDto(Employee e) {
		EmployeeDto dto= new EmployeeDto(
				e.getId(),
				e.getName(),
				e.getEmail(),
				e.getDesignation(),
				e.getSalary()
				
				
				);
		return dto;
		
	}
	
	public static Employee mapDtoToEmployee(EmployeeDto dto) {
		Employee e= new Employee(
				dto.getId(),
				dto.getName(),
				dto.getEmail(),
				dto.getDesignation(),
				dto.getSalary()
				
				
				);
		return e;
	}
}
