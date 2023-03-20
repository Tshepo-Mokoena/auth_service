package com.auth_service.service.auth;

import com.auth_service.json.response.AuthResponse;

public interface IAuthService {
	
	AuthResponse login(String username, String password);

}
