package com.example.springApplication1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springApplication1.payloadDTO.TaskDto;
import com.example.springApplication1.repository.TaskRepository;
import com.example.springApplication1.service.TaskService;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private TaskService taskService;
	
	//save task
	@PostMapping("/{userId}/tasks") 
	public ResponseEntity<TaskDto> createTask(
			@RequestBody TaskDto taskDto,@PathVariable(name = "userId") long userId //this user id was get from post mapping
			){
		System.out.println("Task Dto ---- check userid : "+ userId);
		System.out.println("Task Dto ---- check id : "+taskDto.getId());
		System.out.println("Task Dto ---- check : "+taskDto.getTask());
		return new ResponseEntity<>(taskService.saveTask(userId,taskDto),HttpStatus.CREATED);
	}
	//get all task
	@GetMapping("/{userId}/tasks")
	public ResponseEntity<List<TaskDto>> getAllTask(@PathVariable(name = "userId") long userId){
		return new ResponseEntity<>(taskService.getAllTasks(userId),HttpStatus.OK);
	}
	//get individual task
	@GetMapping("/{userId}/tasks/{taskId}")
	public ResponseEntity<TaskDto> getTask(
			@PathVariable(name="userId") long userId,@PathVariable(name="taskId") long taskId
			){
		System.out.println("Task Dto ---- check userid : "+ userId);
		System.out.println("Task Dto ---- check taskid : "+ taskId);
		return new ResponseEntity<>(taskService.getTask(userId, taskId),HttpStatus.OK);
	}
	
	//delete individual task
	@DeleteMapping("/{userId}/tasks/{taskId}")
	public ResponseEntity<String> deleteTask(
			@PathVariable(name="userId") long userId,@PathVariable(name="taskId") long taskId
			){
		System.out.println("Task Dto ---- check userid : "+ userId);
		System.out.println("Task Dto ---- check taskid : "+ taskId);
		taskService.deleteTask(userId, taskId);
		return new ResponseEntity<>("Task with Id "+taskId+" Deleted for the user "+userId+" successfuly",HttpStatus.OK);
	}
}
