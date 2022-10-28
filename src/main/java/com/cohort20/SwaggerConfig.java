package com.cohort20;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket ShoppingApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Shopping-APIs")
				.select().apis(RequestHandlerSelectors.basePackage("com.cohort20.controller"))
				.build();
	}

}
