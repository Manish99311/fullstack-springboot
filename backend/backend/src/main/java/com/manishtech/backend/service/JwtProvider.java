package com.manishtech.backend.service;

import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.userdetails.User;

@Service
public class JwtProvider {
	 public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	private Key key;
	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	}
	public String generatToken(Authentication authenticaton) {
		User principal = (User) authenticaton.getPrincipal();
		return Jwts.builder()
				.setSubject(principal.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(key)
				.compact();
	}
	public boolean validateToken(String jwt) {
		Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
		return true;
	}
	public String getNameFromJWT(String token) {
		Claims claims = Jwts.parser()
							.setSigningKey(key)
							.parseClaimsJws(token)
							.getBody();
		return claims.getSubject();
	}
}
