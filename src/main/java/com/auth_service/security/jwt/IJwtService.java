package com.auth_service.security.jwt;

import org.springframework.security.core.Authentication;

import com.auth_service.security.UserPrincipal;

import jakarta.servlet.http.HttpServletRequest;

public interface IJwtService {

	String generateJwtToken(UserPrincipal auth);
	
	Authentication getAuthenticated(HttpServletRequest req);

	boolean validateToken(HttpServletRequest req);
	
}
