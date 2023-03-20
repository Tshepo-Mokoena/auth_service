package com.auth_service.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.json.requests.CreateUser;
import com.auth_service.json.response.Response;
import com.auth_service.service.registration.user.IUserRegistrationService;

@RestController
@RequestMapping("/api/registration/user")
public class UserRegistrationAPI {
	
	@Autowired
	private IUserRegistrationService registrationService;
	
	@PostMapping
	public Response<?> register(CreateUser user){
		return Response.builder()
				.status(HttpStatus.CREATED)
				.message("success")
				.data(registrationService.register(user))
				.build();
	}

}
