package com.manishtech.backend.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manishtech.backend.Dao.UserRepository;
import com.manishtech.backend.model.User;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		 User user = userRepository.findByName(name).orElseThrow(()-> new UsernameNotFoundException("no user found with this username"+ name));
		 return new org.springframework.security.core.userdetails.User(user.getName(),
				 user.getPassword(),true,true,true,true,
				 getAuthorities("ROLE_USER"));
	}
	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}

}
