package com.example.springApplication1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springApplication1.entity.Task;


public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findAllByUserId(long userId);

}
