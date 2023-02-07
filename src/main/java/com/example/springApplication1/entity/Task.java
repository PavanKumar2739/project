package com.example.springApplication1.entity;

import jakarta.persistence.Column;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//lambok annotations
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String task;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_Id")
	private Users user;
	//no need to write getters and setters because we used lambok
	//it will create internally
	Task(){
		System.out.println("Constructor called ...........");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String taskname) {
		this.task = taskname;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
}
