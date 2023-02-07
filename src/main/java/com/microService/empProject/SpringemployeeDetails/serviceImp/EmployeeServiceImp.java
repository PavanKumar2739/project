package com.microService.empProject.SpringemployeeDetails.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microService.empProject.SpringemployeeDetails.entity.Employee;
import com.microService.empProject.SpringemployeeDetails.entity.Project;
import com.microService.empProject.SpringemployeeDetails.payload.EmployeeDto;
import com.microService.empProject.SpringemployeeDetails.repo.EmployeeRepository;
import com.microService.empProject.SpringemployeeDetails.repo.ProjectRepository;
import com.microService.empProject.SpringemployeeDetails.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		Employee saveEmp=employeeRepository.save(employee);
		Project project=projectRepository.findByProjCode(saveEmp.getEmpProjCode());
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(saveEmp.getId());
		empDto.setName(saveEmp.getName());
		empDto.setEmail(saveEmp.getEmail());
		
		empDto.setEmpBaseLocation(saveEmp.getEmpBaseLocation());
		empDto.setEmpProjCode(project.getProjCode());
		empDto.setProjName(project.getProjName());
		return empDto;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee getEmp=employeeRepository.findById(id).get();
		Project project=projectRepository.findByProjCode(getEmp.getEmpProjCode());
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(getEmp.getId());
		empDto.setName(getEmp.getName());
		empDto.setEmail(getEmp.getEmail());
		
		empDto.setEmpBaseLocation(getEmp.getEmpBaseLocation());
		empDto.setEmpProjCode(project.getProjCode());
		empDto.setProjName(project.getProjName());
		return empDto;
	}

}
