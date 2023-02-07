package com.microService.empProject.SpringemployeeDetails;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringEmployeeDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEmployeeDetailsApplication.class, args);
		
		
	}
	@Bean
	public ModelMapper moderMapper() {
		return new ModelMapper();
	}

}
