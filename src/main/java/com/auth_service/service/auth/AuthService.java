package com.auth_service.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth_service.json.response.AuthResponse;
import com.auth_service.persistence.user.User;
import com.auth_service.service.user.IUserService;

@Service
public class AuthService implements IAuthService {
	
	@Autowired
	private IUserService userService;
	
	@Override
	public AuthResponse login(String username, String password) {
		
		User user = userService.findByEmail(username)
				.orElseThrow(() -> new RuntimeException("email_or_password invalid".concat(username)));
		
		if (!user.getPassword().matches(password))
			throw new RuntimeException("email_or_password invalid".concat(username));
		
		else
			return AuthResponse.builder()
					.user(user)
					.build();
		
		
	}

}
