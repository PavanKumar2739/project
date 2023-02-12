package com.example.springApplication1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplication1Application.class, args);
	}

	@Bean
	public ModelMapper moderMapper() {
		
		return new ModelMapper();
	}
}
