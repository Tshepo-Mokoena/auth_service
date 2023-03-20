package com.auth_service.persistence.user;

import java.time.LocalDateTime;

import com.auth_service.security.authority.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "app_users")
@SuperBuilder
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "_id", unique = true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "names", updatable = true, nullable = false, length = 50)
	private String names;
	
	@Column(name = "surname", updatable = true, nullable = false, length = 50)
	private String surname;
	
	@Column(name = "email", unique = true, updatable = true, nullable = false)
	private String email;
	
	@Column(name = "phone", unique = true, updatable = true, nullable = false, length = 10)
	private String phone;
	
	@Column(name = "password", updatable = true, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, updatable = true)
	private Role role;
	
	@Column(name = "active", updatable = true, nullable = false)
	private boolean active;
	
	@Column(name = "locked", updatable = true, nullable = false)
	private boolean locked;
	
	@Column(name = "last_login", updatable = false, nullable = true)
	private LocalDateTime lastLogin;
	
	@Column(name = "login_count", updatable = true, nullable = true)
	private int loginCount;
	
	@Column(name = "updated_at", updatable = false, nullable = true)
	private LocalDateTime updatedAt;
		
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt = LocalDateTime.now();
	}	

}
