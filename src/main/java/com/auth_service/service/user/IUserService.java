package com.auth_service.service.user;

import java.util.Optional;

import com.auth_service.persistence.user.User;

public interface IUserService {
	
	User save(User user);
	
	Optional<User> findByEmail(String email);

}
