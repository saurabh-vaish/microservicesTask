package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
@EnableHystrix
public class SpringCloudTaskCoupanProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskCoupanProviderApplication.class, args);
	}

}
