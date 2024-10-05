package com.inn.cafe.JWT;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JWTUtil {

	private String secret="passwordsecret";
	public String extractUsername (String token)
	{
		return extractClaims(token, Claims::getSubject);
	}
	
	public Date extractExpiration (String token)
	{
		return extractClaims(token, Claims::getExpiration);
	}
	
	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
	{
		final Claims claims=extractAllCLaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims extractAllCLaims(String token)
	{
		return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
	}
	private Boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	
	public Boolean ValidateToken(String token, UserDetails userDetails)
	{
		final String username=extractUsername(token);
		return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
}
