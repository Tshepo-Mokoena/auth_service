package com.auth_service.json.response;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
		
	@JsonProperty("status")
	private HttpStatus status;
	
	@JsonProperty("status_code")
	private int statusCode;
	
	@Nullable
	@JsonProperty("data")
	private T data;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@JsonProperty("time_stamp")
	private Date timeStamp;
	
	@JsonProperty("message")
	private String message;
	
	@Nullable
	@JsonProperty("description")
	private String desc;
	
	public int getStatusCode() { return ((HttpStatus) this.status).value(); }
	
	public Date getTimeStamp() { return this.timeStamp = new Date(); }

}
