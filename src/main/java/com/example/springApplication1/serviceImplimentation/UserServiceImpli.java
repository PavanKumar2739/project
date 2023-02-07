package com.example.springApplication1.serviceImplimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springApplication1.entity.Users;
import com.example.springApplication1.payloadDTO.UserDto;
import com.example.springApplication1.repository.UserRepository;
import com.example.springApplication1.service.UserService;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//private passwordEncoder
	@Override
	public UserDto createUser(UserDto userDto) {
		//userDto is not an entity of users
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users user =userDtoToEntity(userDto);//userDto to users class
		Users savedUser=userRepository.save(user);//save the user and return
		return entityToUserDto(savedUser);//return as a response 
	}
	/**
	 * Take user data and set it to entity and return entity
	 * 
	 * @param userDto
	 * @return
	 */
	private Users userDtoToEntity(UserDto userDto) {
		Users users=new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		
		return users;
	}
	/**
	 * 
	 * 
	 * @param savedUsers
	 * @return
	 */
	private UserDto entityToUserDto(Users savedUsers) {
		UserDto userDto=new UserDto();
		userDto.setId(savedUsers.getId());
		userDto.setName(savedUsers.getName());
		userDto.setEmail(savedUsers.getEmail());
		userDto.setPassword(savedUsers.getPassword());
		
		return userDto;
		
	}

}
