package com.concessionaria.innovation.component;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtTokenProvider {

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	@Value("${app.jwtExpirationInMs}")
	private int jwtExpirationInMs;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
	
	
 	public String generateToken(Authentication authentication) {
		User usuario = (User)authentication.getPrincipal();
		
		Date agora = new Date();
		Date dataDeExpiracao = new Date(agora.getTime() + jwtExpirationInMs);
		
		return Jwts.builder()
				.setSubject(usuario.getUsername())
				.setIssuedAt(agora)
				.setExpiration(dataDeExpiracao)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	public String getUserIdFromJWT(String token) {
		return Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException ex) {
			logger.error("Token Inválido");
		} catch (ExpiredJwtException ex) {
			logger.error("Token Expirado");
		} catch (UnsupportedJwtException ex) {
			logger.error("Token não Suportado");
		} catch (IllegalArgumentException ex) {
			logger.error("Token vazio");
		}
		return false;
	}


}
