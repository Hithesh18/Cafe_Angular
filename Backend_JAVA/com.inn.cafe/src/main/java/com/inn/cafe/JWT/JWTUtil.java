package com.inn.cafe.JWT;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JWTUtil {

	private String secret="passwordsecret";
	
	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
	{
		final Claims claims=extractAllCLaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims extractAllCLaims(String token)
	{
		return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
	}
}
