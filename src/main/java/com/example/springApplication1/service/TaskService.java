package com.example.springApplication1.service;

import java.util.List;

import com.example.springApplication1.payloadDTO.TaskDto;

public interface TaskService {
	public TaskDto saveTask(long userId, TaskDto taskDto);

	public List<TaskDto> getAllTasks(long userId);

	public TaskDto getTask(long userId, long taskId);//find the id that is assigned to user
	
	public void deleteTask(long userId,long taskid);

}
