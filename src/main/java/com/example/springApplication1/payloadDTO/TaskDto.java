package com.example.springApplication1.payloadDTO;

import lombok.Getter;
import lombok.Setter;



public class TaskDto {

	private long id;
	private String task;
	
	TaskDto(){
		System.out.println("constructor Task Dto.................");
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
	
	
}
