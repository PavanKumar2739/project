package com.example.springApplication1.payloadDTO;

public class JwtAuthResponce {
	private String token;
	private String tokenType="Bearer";
	
	public JwtAuthResponce(String token) {
		this.token=token;
	}

	public String getToken() {
		return token;
	}
	
	public String getTokenType() {
		return tokenType;
	}
}
