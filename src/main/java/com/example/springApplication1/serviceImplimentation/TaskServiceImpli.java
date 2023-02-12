package com.example.springApplication1.serviceImplimentation;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springApplication1.entity.Task;
import com.example.springApplication1.entity.Users;
import com.example.springApplication1.exception.DataNotMatched;
import com.example.springApplication1.exception.TaskNotFound;
import com.example.springApplication1.exception.UserNotFound;
import com.example.springApplication1.payloadDTO.TaskDto;
import com.example.springApplication1.repository.TaskRepository;
import com.example.springApplication1.repository.UserRepository;
import com.example.springApplication1.service.TaskService;

@Service
public class TaskServiceImpli implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepo;

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		Users users = null;
		users = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFound(String.format("Uasr with %d not found", userId)));// throw error if
																										// its not
																										// exists
		// doing using modelMapper
		System.out.println("Users +=============" + users.getId());

		Task task = modelMapper.map(taskDto, Task.class);
		task.setUser(users);
//		System.out.println(task);
//		System.out.println("came here ....................."+task.getTask());
		// after setting the user we are storing the data into Db
		Task saveTask = taskRepository.save(task);
		return modelMapper.map(saveTask, TaskDto.class);
//		Task task = convertTaskDtoToTask(taskDto);
//		Task saveTask= taskRepository.save(task);
//		
//		return convertTaskToTaskDto(saveTask);

	}

//    public Task convertTaskDtoToTask(TaskDto taskDto) {
//    	Task task=new Task();
//    	task.setTaskName("Api testing");
//    	
//    	return task;
//    	
//    }
//    public TaskDto convertTaskToTaskDto(Task saveTask) {
//    	TaskDto td=new TaskDto();
//    	td.setId(saveTask.getId());
//    	td.setTaskName(saveTask.getTaskName());
//    	
//    	return td;
//    }
	@Override
	public List<TaskDto> getAllTasks(long userId) {
		userRepo.findById(userId).orElseThrow(() -> new UserNotFound(String.format("Uasr with %d not found", userId)));
		List<Task> tasks = taskRepository.findAllByUserId(userId);// it will work because of it has automatically work
		return tasks.stream().map(// Stream is used to map one obj to another object
				task -> modelMapper.map(task, TaskDto.class)// converting list of task to list of TaskDto
		).collect(Collectors.toList());
	}

	@Override
	public TaskDto getTask(long userId, long taskId) {
		Users user = userRepo.findById(userId)
				.orElseThrow( ()-> new UserNotFound(String.format("Uasr with %d not found", userId)));
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFound(String.format("Task with %d not found", taskId)));
		
		System.out.println("task and user id : "+task.getId()+"!="+task.getUser().getId());
		if(user.getId()!=task.getUser().getId()) {//if the given task id not belongs to that user id we had provided
			throw new DataNotMatched(String.format("Task id %d not belongs to user id %d", taskId,userId));
		}
		return modelMapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTask(long userId, long taskId) {
		Users user = userRepo.findById(userId)
				.orElseThrow( ()-> new UserNotFound(String.format("Uasr with %d not found", userId)));
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFound(String.format("Task with %d not found", taskId)));
		
		System.out.println("task and user id : "+task.getId()+"!="+task.getUser().getId());
		if(user.getId()!=task.getUser().getId()) {//if the given task id not belongs to that user id we had provided
			throw new DataNotMatched(String.format("Task id %d not belongs to user id %d", taskId,userId));
		}
	taskRepository.deleteById(taskId);
		
	}

}
