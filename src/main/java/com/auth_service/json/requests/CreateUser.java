package com.auth_service.json.requests;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUser {
	
	@JsonProperty("names")
	private String names;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	
	public LocalDateTime getCreatedAt() {
		return this.createdAt = LocalDateTime.now();
	}

}
