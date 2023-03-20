package com.auth_service.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth_service.persistence.user.User;
import com.auth_service.security.authority.Role;
import com.auth_service.security.util.Util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails{
	
	private Long id;
	
	private String email;
	
	transient private String password;
	
	transient private User user;
	
	private Set<GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !user.isLocked();
	}

	@Override
	public boolean isEnabled() {
		return this.user.isActive();
	}

	public static UserPrincipal createdAdmin() {
		
		Set<GrantedAuthority> authorities = 
				Set.of(Util.convertToAuthority(Role.SYSTEM_ADMINISTRATOR.name()));
		
		SystemAdministrator system = new SystemAdministrator();
		
		return UserPrincipal.builder()
				.id(-1L)
				.email(system.getEmail())
				.authorities(authorities)
				.build();
	}

}
