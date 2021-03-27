package com.manishtech.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manishtech.backend.Dao.UserRepository;
import com.manishtech.backend.dto.RegisterRequest;
import com.manishtech.backend.model.User;

@Service
public class AuthService {
//	@Autowired
//	private User user;
	@Autowired
	private UserRepository userRepository;
	
	public void singup(RegisterRequest registerRequest) {
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setEmailId(registerRequest.getEmailId());
		user.setPassword(registerRequest.getPassword());
		userRepository.save(user);
	}

}
