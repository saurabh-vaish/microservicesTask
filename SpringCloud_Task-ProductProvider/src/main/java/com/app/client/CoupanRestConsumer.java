package com.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.model.Coupan;

@FeignClient("COUPAN-APP")
public interface CoupanRestConsumer {

	@GetMapping("/rest/coupan/getByCode/{code}")
	public Coupan getCoupanByCode(@PathVariable String code);
	
	
	@GetMapping("/rest/coupan/check/{code}")
	public String checkExpiredOrNot(@PathVariable String code);
	
	
}
