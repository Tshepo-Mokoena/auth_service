package com.auth_service.json.response;

import org.springframework.lang.Nullable;

import com.auth_service.persistence.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
	
	@JsonProperty("names")
	private String names;
	
	@JsonProperty("surname")
	private String surname;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone")
	private String phone;
	
	@Nullable
	@JsonProperty("token")
	private String token;	
	
	private transient User user;
	
	public String getSurname() {
		return this.surname = this.user.getSurname();
	}

	public String getEmail() {
		return email = this.user.getEmail();
	}

	public String getPhone() {
		return phone = this.user.getPhone();
	}

}
