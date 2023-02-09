package com.auth_service.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth_service.persistence.user.User;
import com.auth_service.persistence.user.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

}
