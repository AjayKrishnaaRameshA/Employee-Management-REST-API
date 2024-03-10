package com.employee.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDto {

	private Long id;
	private String name;
	private String email;
	private String designation;
	private Double salary;

}
