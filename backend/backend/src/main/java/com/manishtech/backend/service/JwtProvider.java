package com.manishtech.backend.service;

import java.security.Key;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.User;

@Service
public class JwtProvider {
	private Key key;
	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	}
	public String generatToken(Authentication authenticaton) {
		User principal = (User) authenticaton.getPrincipal();
		return Jwts.builder()
				.setSubject(principal.getUsername())
				.signWith(key)
				.compact();
	}
}
