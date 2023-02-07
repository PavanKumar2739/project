package com.microService.empProject.SpringemployeeDetails.service;

import org.springframework.stereotype.Service;

import com.microService.empProject.SpringemployeeDetails.entity.Project;
import com.microService.empProject.SpringemployeeDetails.payload.EmployeeDto;

@Service
public interface ProjectService {
	public Project saveProject(Project project);

	public Project getProjectByCode(long projectCode);
}
