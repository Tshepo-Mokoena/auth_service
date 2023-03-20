package com.auth_service.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.auth_service.json.response.AuthResponse;
import com.auth_service.persistence.user.User;
import com.auth_service.persistence.user.UserRepository;
import com.auth_service.security.authority.Role;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public Page<User> findByNameContaining(String keyword, int page, int pageSize){
		return userRepo.findByNamesContaining(keyword, PageRequest.of(page, pageSize));
	}
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public AuthResponse changeRole(String email, Role role) {
		return AuthResponse.builder()
				.user(userRepo.changeRole(email, role))
				.build();
	}

}
