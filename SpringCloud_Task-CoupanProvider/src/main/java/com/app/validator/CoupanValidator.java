package com.app.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.exception.ApiError;
import com.app.model.Coupan;

@Component
public class CoupanValidator implements Validator{

	@Autowired
	private ApiError api=new ApiError();
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Coupan.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		
		Coupan c = (Coupan) target;
		
		if(StringUtils.isEmpty(c.getCoupanId().toString()))
		{
			errors.reject("coupanId");
			api.getValidationErrors().add("Please Provide Coupan Id");
		}
		
		if(StringUtils.isEmpty(c.getCoupanCode()))
		{
			errors.reject("coupanCode");
			api.getValidationErrors().add("Please Provide Coupan Code ");
		}
		
		if(StringUtils.isEmpty(c.getCoupanDisc().toString()))
		{
			errors.reject("coupanDisc");
			api.getValidationErrors().add("Please Provide Coupan Discount ");
		}

		if(c.getCoupanDisc()<0)
		{
			errors.reject("coupanDisc");
			api.getValidationErrors().add("Please Provide Valid Discount ");
		}
		
		if(StringUtils.isEmpty(c.getExpDate()))
		{
			errors.reject("expDate");
			api.getValidationErrors().add("Please Provide Coupan Expiray Date");
		}
		
		if(c.getExpDate().before(new Date()))
		{
			errors.reject("expDate");
			api.getValidationErrors().add("Please Provide Valid Expiray Date");			
		}
		
		
		
		
	}

	
	
	
}
