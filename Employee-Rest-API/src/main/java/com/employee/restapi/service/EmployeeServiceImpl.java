package com.employee.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.restapi.dto.EmployeeDto;
import com.employee.restapi.entity.Employee;
import com.employee.restapi.mapper.EmployeeMapper;
import com.employee.restapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> empList=repository.findAll();
		return empList.
				stream().
				map((e->EmployeeMapper.mapEmployeeToDto(e))).
				collect(Collectors.toList());
	}

	@Override
	public EmployeeDto save(EmployeeDto dto) {
		Employee e = EmployeeMapper.mapDtoToEmployee(dto);
		
		repository.save(e);
		
		return EmployeeMapper.mapEmployeeToDto(e);
		
	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {
		Employee employee=repository.
							findById(id).
							orElseThrow(()-> new RuntimeException("Employee not found"));
		return EmployeeMapper.mapEmployeeToDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto updateEmployee) {
		Employee employee=repository.
				findById(id).
				orElseThrow(()-> new RuntimeException("Employee not found"));
		
		employee.setName(updateEmployee.getName());
		employee.setEmail(updateEmployee.getEmail());
		employee.setDesignation(updateEmployee.getDesignation());
		employee.setSalary(updateEmployee.getSalary());
		
		Employee update=repository.save(employee);
		
		return EmployeeMapper.mapEmployeeToDto(update);
	}

	@Override
	public void deleteById(Long id) {
		Optional<Employee> e = repository.findById(id);
		if(e.isPresent()) {
			repository.deleteById(id);
		}
	}

}
