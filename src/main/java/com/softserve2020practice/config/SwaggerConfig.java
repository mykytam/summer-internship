package com.softserve2020practice.config;

import com.softserve2020practice.constants.Headers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {

        Parameter parameter = new ParameterBuilder()
                .name(Headers.AUTH_HEADER)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .description("JWT token")
                .build();

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.softserve2020practice.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiDetails())
                .globalOperationParameters(singletonList(parameter));
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
