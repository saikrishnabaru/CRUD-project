package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "emp_name")
    private String name;
    
    private String department;
    
    private Long salary;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
  		return department;
  	}

  	public void setDepartment(String department) {
  		this.department = department;
  	}

  	public Long getSalary() {
  		return salary;
  	}

  	public void setSalary(Long salary) {
  		this.salary = salary;
  	}
}
