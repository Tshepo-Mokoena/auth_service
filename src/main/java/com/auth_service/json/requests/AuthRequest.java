package com.auth_service.json.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthRequest {
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("password")
	private String password;

}
