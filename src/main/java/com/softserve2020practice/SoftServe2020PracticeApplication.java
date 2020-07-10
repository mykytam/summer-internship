package com.softserve2020practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SoftServe2020PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftServe2020PracticeApplication.class, args);
	}

	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.softserve2020practice"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"SoftServe Summer Project 2020 API made by Romeo Team",
				"REST API for IT courses",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Romeo Team", "", ""),
				"API License",
				"",
				Collections.emptyList());
	}


}
