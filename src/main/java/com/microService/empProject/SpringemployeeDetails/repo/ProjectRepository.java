package com.microService.empProject.SpringemployeeDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microService.empProject.SpringemployeeDetails.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
Project findByProjCode(long employeeAssignedProject);
}
