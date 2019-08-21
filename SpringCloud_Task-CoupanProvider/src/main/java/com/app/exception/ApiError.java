package com.app.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ApiError{
	
	private String errorCode;
	private String errorDesc;
	private Date errorDate;
	
	private List<String> validationErrors =new ArrayList<>();

	
}
