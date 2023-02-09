package com.auth_service.json.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
		
	private HttpStatus status;
	
	private int statusCode;
	
	@Nullable
	private T data;
	
	private Date timeStamp;
	
	private String message;
	
	@Nullable
	private String desc;
	
	public int getStatusCode() { return this.statusCode = this.status.value(); }
	
	public Date getTimeStamp() { return this.timeStamp = new Date(); }

}
