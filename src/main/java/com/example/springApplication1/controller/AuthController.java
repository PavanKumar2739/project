package com.example.springApplication1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springApplication1.entity.Users;
import com.example.springApplication1.exception.UserNotFound;
import com.example.springApplication1.payloadDTO.JwtAuthResponce;
import com.example.springApplication1.payloadDTO.LoginDto;
import com.example.springApplication1.payloadDTO.UserDto;
import com.example.springApplication1.repository.UserRepository;
import com.example.springApplication1.security.JwtTokenProvider;
import com.example.springApplication1.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@GetMapping(value = "/login")
	public String home() {

//		 HttpHeaders headers = new HttpHeaders();
//		 headers.setContentType(MediaType.TEXT_HTML);
//		 return new ResponseEntity<>("login.jsp",headers, HttpStatus.OK);
		return "login";
	}
	@GetMapping(value = "/register")
	public String registerPage() {
	    return "register";
	}
	@PostMapping("/next")
	public String name() {
		return "success1";
	}
	// store the user in db
	@PostMapping("/registerSuccess")
	public String createUser( UserDto userDto, Model model) {

	System.out.println("mail id ======" + userDto.getId());
	System.out.println("mail id ======" + userDto.getEmail());
	System.out.println("mail id ======" + userDto.getPassword());
		userService.createUser(userDto);
model.addAttribute("message","Your Registration is Successfull");
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.TEXT_HTML);
		return "success1";
	}

	@PostMapping("/success")
	public String loginUser(LoginDto loginDto,Model model ) {
	System.out.println("email : "+loginDto.getEmail());
	System.out.println("email : "+loginDto.getPassword());
	
	String email=loginDto.getEmail();
		Authentication auth=
				authManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
						);
		System.out.println(auth);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		System.out.println(auth);
		//String token=jwtTokenProvider.generateToken(auth);//generates the token and save it to token
		Users user=userRepository.findByEmail(email)
				         .orElseThrow(() -> new UserNotFound(String.format("Uasr with %d not found", email)));;
		System.out.println("token generated ");
		model.addAttribute("name",user.getName());
		    return "homePage";
	}

}
