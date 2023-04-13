package com.auth_service.client.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.json.response.Response;
import com.auth_service.persistence.user.User;
import com.auth_service.security.authority.Role;
import com.auth_service.service.user.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/system/user")
public class SystemAdministratorAPI {
	
	@Autowired
	private IUserService userService;
	
	@PutMapping
	public Response<?> makeAdministrator(@RequestParam("email") String email){
		
		return Response.builder()
				.status(HttpStatus.OK)
				.message("success")
				.data(userService.changeRole(email, Role.ADMINISTRATOR))
				.build();
		
	}
	
	@GetMapping
	public Response<?> getUsers(
			@RequestParam("keyword") Optional<String> keyword,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("pageSize") Optional<Integer> pageSize){
		
		return Response.builder()
				.status(HttpStatus.OK)
				.message("success")
				.data(userService.findByNameContaining(keyword.orElse(""), page.orElse(0), pageSize.orElse(10)))
				.build();
	}
	
	@PostMapping
	public Response<?> updateUser(@RequestBody @Valid User user){
		
		if (userService.findByEmail(user.getEmail()).isPresent())
			throw new RuntimeException("user_not_found");		
		
		return Response.builder()
				.status(HttpStatus.OK)
				.message("success")
				.data(userService.save(user))						
				.build();
		
	}

}
