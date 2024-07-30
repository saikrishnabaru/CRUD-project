package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee,Long>{


	List<Employee> findBySalaryGreaterThan(long l);

	List<Employee> findByDepartment(String string);

	List<Employee> findByName(String string);

	List<Employee> findBySalaryBetween(long l, long m);

	Optional<Employee> findByDepartmentAndSalaryGreaterThan(String string, long l);

	
	//Custom query
	@Query("select e.name from Employee e where e.name=:name and e.salary=:salary")
	Optional<Employee> findByNameAndSalary(String name, long salary);

}
