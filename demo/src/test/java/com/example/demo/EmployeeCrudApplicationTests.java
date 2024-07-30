package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeCrudRepo;

@SpringBootTest
class EmployeeCrudApplicationTests {

	@Autowired
	EmployeeCrudRepo employeeCrudRepo;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testRepository()
	{
		Employee ep1 = Employee.builder()
				.id(101L)
				.name("sai").department("SDE")
                .salary(50000L)
                .build();
		Employee ep2 = Employee.builder()
				.id(102L)
				.name("krishna").department("Tester")
                .salary(30000L)
                .build();
		Employee ep3 = Employee.builder()
				.id(103L)
				.name("varma").department("Devops")
                .salary(50000L)
                .build();				
		employeeCrudRepo.save(ep1);		
		employeeCrudRepo.save(ep2);	
		employeeCrudRepo.save(ep3);	
				
	}
	
	
		 @Test
		    void customMethods() {
		        // Find employees by department
		        List<Employee> sdeEmployees = employeeCrudRepo.findByDepartment("SDE");
		        System.out.println("SDE Employees: " + sdeEmployees);
		        
		        // Find employees by name
		        List<Employee> saiEmployees = employeeCrudRepo.findByName("sai");
		        System.out.println("Employees named 'sai': " + saiEmployees);
		        
		        // Find employees with salary greater than a specified amount
		        List<Employee> highSalaryEmployees = employeeCrudRepo.findBySalaryGreaterThan(40000L);
		        System.out.println("Employees with salary greater than 40000: " + highSalaryEmployees);
		        
		        // Find employees with salary between two amounts
		        List<Employee> midSalaryEmployees = employeeCrudRepo.findBySalaryBetween(30000L, 50000L);
		        System.out.println("Employees with salary between 30000 and 50000: " + midSalaryEmployees);
		        
		        // Find employees by department and salary greater than a specified amount and keeping it optional to avoid null
		        Optional<Employee> sdeHighSalaryEmployees = employeeCrudRepo.findByDepartmentAndSalaryGreaterThan("SDE", 40000L);
		        sdeHighSalaryEmployees.ifPresent(System.out::println);
		        
		        Optional<Employee> nameAndSalary = employeeCrudRepo.findByNameAndSalary("sk", 50000L);
		        nameAndSalary.ifPresent(System.out::println);
		    
		    }
	
	
	
	
	

}
