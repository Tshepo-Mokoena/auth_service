package com.auth_service.service.registration.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth_service.json.requests.CreateUser;
import com.auth_service.persistence.user.User;
import com.auth_service.security.authority.Role;
import com.auth_service.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRegistrationService  implements IUserRegistrationService{
	
	@Autowired
	private IUserService userService;

	@Override 
	public CreateUser register(CreateUser createUser) {
		
		if (userService.findByEmail(createUser.getEmail()).isPresent())
			throw new RuntimeException("email_exist:".concat(createUser.getEmail()));
		
		User user = User.builder()
				.names(createUser.getNames())
				.surname(createUser.getSurname())
				.email(createUser.getEmail())
				.phone(createUser.getPhone())
				.password(createUser.getPassword())
				.role(Role.USER)
				.active(true)
				.locked(false)
				.build();
		
		log.info(user.toString());
		
		userService.save(user);
		
		return createUser;
	}

}
