package com.manishtech.backend.model;

public class AuthenticationResponse {
	private String authenticationToken;
	private String name;
	
	
	public AuthenticationResponse() {
		super();
	}


	public AuthenticationResponse(String authenticationToken, String name) {
		super();
		this.authenticationToken = authenticationToken;
		this.name = name;
	}


	public String getAuthenticationToken() {
		return authenticationToken;
	}


	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
