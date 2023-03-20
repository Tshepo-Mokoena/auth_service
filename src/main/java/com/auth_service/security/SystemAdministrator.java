package com.auth_service.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class SystemAdministrator {

	@Value("${system.email}")
	private String email;

}
