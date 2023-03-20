package com.auth_service.security.util;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class Util {	

	public static final String ROLE_PREFIX = "ROLE_";

	public static final String AUTH_HEADER = "authorization";

	public static final String AUTH_TOKEN_TYPE = "Bearer";

	public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";

	public static SimpleGrantedAuthority convertToAuthority(String role) {		
		
		String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
		
		return new SimpleGrantedAuthority(formattedRole);
	}

	public static String extractAuthTokenFromRequest(HttpServletRequest req) {
		
		String bearerToken = req.getHeader(AUTH_HEADER);

		if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX))
			return bearerToken.substring(7);

		return null;
	}

}
