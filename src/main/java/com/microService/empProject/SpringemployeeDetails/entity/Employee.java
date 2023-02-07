package com.microService.empProject.SpringemployeeDetails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private long empProjCode;
	@Column(nullable = false)
	private String empBaseLocation;
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
	
	
}
