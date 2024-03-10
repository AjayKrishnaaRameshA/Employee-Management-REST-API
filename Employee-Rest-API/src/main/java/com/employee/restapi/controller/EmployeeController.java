package com.employee.restapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.restapi.dto.EmployeeDto;
import com.employee.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> dto = service.getAllEmployees();
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/employee/add")
	public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody EmployeeDto dto ){
		//service.save(dto);
		return new ResponseEntity<EmployeeDto>(service.save(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
								@RequestBody EmployeeDto dto){
		EmployeeDto dto1 = service.updateEmployee(id, dto);
		return ResponseEntity.ok(dto1);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
		
		service.deleteById(id);
		
		return ResponseEntity.ok("account deleted successfully");
	}
	
	
}
