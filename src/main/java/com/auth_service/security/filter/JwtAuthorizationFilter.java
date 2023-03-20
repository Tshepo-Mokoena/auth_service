package com.auth_service.security.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth_service.security.jwt.IJwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
	
	@Autowired
	private IJwtService jwtService;
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		return request.getRequestURI().startsWith("/api/system/user");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication = jwtService.getAuthenticated(request);
		
		if( authentication != null && jwtService.validateToken(request))
			SecurityContextHolder.getContext().setAuthentication(authentication);
				
		filterChain.doFilter(request, response);
		
	}


}
