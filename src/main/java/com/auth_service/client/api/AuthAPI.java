package com.auth_service.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.json.requests.AuthRequest;
import com.auth_service.json.response.Response;
import com.auth_service.service.auth.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {
	
	@Autowired
	private IAuthService authService;
	
	@PostMapping("/login")
	public Response<?> login(@RequestBody AuthRequest authRequest){
		
		return Response.builder()
				.status(HttpStatus.OK)
				.message("success")
				.data(authService.login(authRequest.getEmail(), authRequest.getPassword()))
				.build();
		
	}

}
