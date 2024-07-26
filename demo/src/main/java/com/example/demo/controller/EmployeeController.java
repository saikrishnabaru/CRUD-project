
package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/demo")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee employee2 = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		List<Employee> employee2 = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<>(employee2, HttpStatus.OK);
	}
	
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id") Long empId)
	{
		Employee employee2 = employeeServiceInterface.getEmployeeById(empId);
		return new ResponseEntity<>(employee2, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/emp/delete/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long empId)
	{
		employeeServiceInterface.deleteEmployeeById(empId);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee employee2 = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}
	
}
