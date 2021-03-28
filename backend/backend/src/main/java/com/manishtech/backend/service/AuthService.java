package com.manishtech.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manishtech.backend.LoginRequest;
import com.manishtech.backend.Dao.UserRepository;
import com.manishtech.backend.dto.RegisterRequest;
import com.manishtech.backend.model.User;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	public void singup(RegisterRequest registerRequest) {
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setEmailId(registerRequest.getEmailId());
		user.setPassword(encodePassword(registerRequest.getPassword()));
		userRepository.save(user);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password); 
	}

	public String login(LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return jwtProvider.generatToken(authenticate);
	}

}
