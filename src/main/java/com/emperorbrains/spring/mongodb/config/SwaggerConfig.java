package com.emperorbrains.spring.mongodb.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author RajuKhunt
 * 
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@SuppressWarnings("unused")
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for POC", "1.0",
				"Terms of service",
				new Contact("Raju Khunt", "https://github.com/rkrajukhunt", "rajukhunt15@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", null);
		return apiInfo;
	}
}
