package com.auth_service.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.json.requests.CreateUser;
import com.auth_service.json.requests.Response;
import com.auth_service.service.registration.IRegistrationService;

@RestController
@RequestMapping("/api/registration")
public class RegistrationAPI {
	
	@Autowired
	private IRegistrationService registrationService;
	
	@PostMapping
	public Response<?> register(CreateUser user){
		return Response.builder()
				.status(HttpStatus.CREATED)
				.message("success")
				.data(registrationService.register(user))
				.build();
	}

}
