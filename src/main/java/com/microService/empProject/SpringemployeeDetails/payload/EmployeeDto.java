package com.microService.empProject.SpringemployeeDetails.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeDto {
	private long id;
	private String name;
	private String email;
	private long empProjCode;
	private String empBaseLocation;
	private String projName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getEmpProjCode() {
		return empProjCode;
	}
	public void setEmpProjCode(long empProjCode) {
		this.empProjCode = empProjCode;
	}
	public String getEmpBaseLocation() {
		return empBaseLocation;
	}
	public void setEmpBaseLocation(String empBaseLocation) {
		this.empBaseLocation = empBaseLocation;
	}
//	public long getProjCode() {
//		return projCode;
//	}
//	public void setProjCode(long projCode) {
//		this.projCode = projCode;
//	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
}
