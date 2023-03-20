package com.auth_service.service.user;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.auth_service.json.response.AuthResponse;
import com.auth_service.persistence.user.User;
import com.auth_service.security.authority.Role;

public interface IUserService {
	
	User save(User user);
	
	Optional<User> findByEmail(String email);

	AuthResponse changeRole(String email, Role administrator);

	Page<User> findByNameContaining(String keyword, int page, int pageSize);

}
