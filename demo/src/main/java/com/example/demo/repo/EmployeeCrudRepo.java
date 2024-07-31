package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee,Long>{


	List<Employee> findBySalaryGreaterThan(long l);

	List<Employee> findByDepartment(String department);

	List<Employee> findByName(String name);

	List<Employee> findBySalaryBetween(long l, long m);

	Optional<Employee> findByDepartmentAndSalaryGreaterThan(String department, long l);

	
	
	//Custom query
	@Query("select e.name from Employee e where e.name=:name and e.salary=:salary")
	Optional<Employee> findByNameAndSalary(String name, long salary);
	
	
	List<Employee> findByDepartmentOrderBySalary(String department);
	
	List<Employee> findBy(Pageable page);

}
