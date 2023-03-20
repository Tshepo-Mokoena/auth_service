package com.auth_service.security.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth_service.persistence.user.User;
import com.auth_service.security.UserPrincipal;
import com.auth_service.security.util.Util;
import com.auth_service.service.user.IUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IUserSecurityService implements UserDetailsService{
	
	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userService.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("email_or_password_invalid"));
		
		Set<GrantedAuthority> authority = Set.of(Util.convertToAuthority(user.getRole().name()));
		
		UserPrincipal userPrincipal = UserPrincipal.builder()
				.id(user.getId())
				.email(user.getEmail())
				.authorities(authority)
				.user(user)
				.build();
		
		log.info(userPrincipal.toString());
		
		return userPrincipal;
	}	 

}
