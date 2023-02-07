package com.microService.empProject.SpringemployeeDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microService.empProject.SpringemployeeDetails.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
