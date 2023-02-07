package com.example.springApplication1.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.springApplication1.exception.DataNotMatched;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
	
	public String generateToken(Authentication authentication) {
		String email=authentication.getName();
		Date currentDate=new Date();
		Date expireDate=new Date(currentDate.getTime()+360000);//milliseconds
		System.out.println(currentDate+" "+expireDate);
		System.out.println("token called ");
		String token=Jwts.builder()
				.setSubject(email)
				.setIssuedAt(currentDate)
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, "JWTSecretKey")
				.compact();
		System.out.println("token created");
		return token;//creates the token and return it 
		
	}
	public String getEmailFromToken(String token) {
		Claims claims= Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token).getBody();
		
		return claims.getSubject();
		
	}
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey("JWTSecretKey").parseClaimsJws(token);
			return true;
		}
		catch (Exception e) {
			
			throw new DataNotMatched("token not matched : "+e.getMessage());
		}
	}

}
