package com.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.service.CoupanService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudTaskCoupanProviderApplicationTests {

	@Autowired
	private CoupanService service;
	
	@Test
	public void contextLoads() {
		boolean f =service.isExpired("AUG15");System.out.println(f);
		assertTrue("coupan expired", f);
	}

}
