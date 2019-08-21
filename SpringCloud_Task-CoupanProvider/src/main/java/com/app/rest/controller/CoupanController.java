package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.CoupanNotFoundException;
import com.app.exception.ValidationError;
import com.app.model.Coupan;
import com.app.service.CoupanService;
import com.app.validator.CoupanValidator;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/coupan")
public class CoupanController {

	@Autowired
	private CoupanService service;
	
	@Autowired
	private CoupanValidator validator;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCoupan(@RequestBody Coupan coupan,Errors errors)
	{
		validator.validate(coupan, errors);
		
		if(!errors.hasErrors())
		{
			service.saveCoupan(coupan);
			return new ResponseEntity<String>("coupan has been added successfully",HttpStatus.OK);
		}
		else
		{
			throw new ValidationError("Please Provide Valid Details");
		}
	}
	
	
	
	@GetMapping("/check/{code}")
	public String checkExpiredOrNot(@PathVariable String code)
	{
		return service.isExpired(code)?"Not Expired":"Expired";
	}
	
	
	
	
	@GetMapping("/getOne/{id}")
	@HystrixCommand(fallbackMethod = "getCoupanException")
	public Coupan getOneCoupan(@PathVariable Integer id)
	{
		Coupan c = service.getCoupanById(id);
		
		if(c!=null)
		{
			return c;
		}
		else
		{
			throw new CoupanNotFoundException("No Coupan Found");
		}
		
	}
	
	
	@GetMapping("/getByCode/{code}")
	//@HystrixCommand(fallbackMethod = "getCoupanCodeException")
	public Coupan getCoupanByCode(@PathVariable String code)
	{
		System.out.println(code);
		Coupan c = service.getCoupanByCode(code);
		
		if(c!=null)
		{
			return c;
		}
		else
		{
			throw new CoupanNotFoundException("No Coupan Found");
		}
		
	}
	
	
	
	// fallback method
	public Coupan getCoupanException(Integer id)
	{
		throw new CoupanNotFoundException("No Coupan Found");
	}
	
	public Coupan getCoupanCodeException(String code)
	{
		throw new CoupanNotFoundException("No Coupan Found");
	}
	
	
	
	@GetMapping("/all")
	public List<Coupan> getAllCoupans()
	{
		List<Coupan> list =service.getAllCoupans();
		System.out.println(list);
		return list;
	}
	
	
	
	
	@PostMapping("/update")
	public ResponseEntity<String> updateCoupan(@RequestBody Coupan coupan,Errors errors)
	{
		if(service.isExist(coupan.getCoupanId()))
		{
			
			validator.validate(coupan, errors);
			
			if(!errors.hasErrors())
			{
				service.saveCoupan(coupan);
				return new ResponseEntity<String>("coupan has been updated successfully",HttpStatus.OK);
			}
			else
			{
				throw new ValidationError("Please Provide Valid Details");
			}
			
		}
		else
		{
			throw new CoupanNotFoundException("No Coupan Found");
		}
		
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCoupan(@PathVariable Integer id)
	{
		
		if(service.isExist(id))
		{
			service.deleteCoupanById(id);
			
			return new ResponseEntity<String>("Coupan Deleted Successfully",HttpStatus.OK);
		}
		else
		{
			throw new CoupanNotFoundException("No Coupan Found");
		}
		
	}
	
	
	
}
