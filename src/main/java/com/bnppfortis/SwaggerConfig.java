package com.bnppfortis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This Class defines the Swagger Documentation configuration and base setup.
 * <p>
 * Created by Dev2018039 on 12/22/2018.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket channelsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bnppfortis"))
                .paths(regex("/channels.*"))
                .build()
                .apiInfo(apiInfoMetaData());
    }

    /**
     * This private method is used to define the properties for Swagger documentation.
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfoMetaData() {
        Contact contact = new Contact("Dev2018039", "http://github.com/dev2018039", "XXXX@gmail.com");

        return new ApiInfo(
                "Leap Year Channels Assignment",
                "Spring Boot REST API for Channels Leap Year Assignment",
                "1.0",
                "Terms of service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
    }
}