package com.example.springApplication1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springApplication1.payloadDTO.JwtAuthResponce;
import com.example.springApplication1.payloadDTO.LoginDto;
import com.example.springApplication1.payloadDTO.UserDto;
import com.example.springApplication1.security.JwtTokenProvider;
import com.example.springApplication1.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	// store the user in db
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

//		System.out.println("mail id ======" + userDto.getId());
//		System.out.println("mail id ======" + userDto.getEmail());

		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponce> loginUser( @RequestBody LoginDto loginDto ) {
//		System.out.println("email : "+loginDto.getEmail());
//		System.out.println("email : "+loginDto.getPassword());
		Authentication auth=
				authManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
						);
		System.out.println(auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String token=jwtTokenProvider.generateToken(auth);//generates the token and save it to token
		System.out.println("token generated ");
		    return ResponseEntity.ok(new JwtAuthResponce(token));
	}

}
