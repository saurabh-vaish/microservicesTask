package com.app.config;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket configSwagger()
	{
		return new Docket(DocumentationType.SWAGGER_2)				
				.select()											
				.apis(basePackage("com.app.rest.controller"))		 
				.paths(regex("/rest.*"))						
				.build()									
				
				// optional
				.apiInfo(apiInfo())				 
				;
	}
	
	
	// it is optional only to provide additional details
	private ApiInfo apiInfo()
	{
		return new ApiInfoBuilder() 			// using builder factory ApiInfoBuilder that will make easy to construct object and return ApiInfo
				.title("My Project Swagger")
				.description("this is swagger implementation for rest")
				.contact(new Contact("saurabh vaish","www.github.com/saurabh-vaish", "saurabh.vaish1993@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0")
				.build();
	}
}
