package com.example.springApplication1.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springApplication1.entity.Users;
import com.example.springApplication1.exception.UserNotFound;
import com.example.springApplication1.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users user = userRepository.findByEmail(email).orElseThrow(
				()-> new UserNotFound(String.format("Given Username %d Password incorrect", "or"))
				);
		Set<String> role =new HashSet<>();
		role.add("ROLE_ADMIN");
		
		return new User(user.getEmail(), user.getPassword(), userAuthorities(role));
	}
	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> role){
		return role.stream().map(
				rol-> new SimpleGrantedAuthority(rol)//sub type of granted authorities
				).collect(Collectors.toList());//make it as list
	}

}
