package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee savedEmp =crudRepo.save(employee);
		return savedEmp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return crudRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		return crudRepo.findById(empId).get();
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		crudRepo.deleteById(empId);
	}

	@Override
	public List<Employee> findByDepartmentOrderBySalary(String department) {
		// TODO Auto-generated method stub
		return crudRepo.findByDepartmentOrderBySalary(department);
	}

	@Override
	public List<Employee> findBy(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		return crudRepo.findBy(pageRequest);
	}

}
