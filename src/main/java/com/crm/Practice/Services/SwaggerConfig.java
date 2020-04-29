package com.crm.Practice.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//Enable Swegger
@EnableSwagger2
public class SwaggerConfig {
    //creating bean
    @Bean
    //creating constructor of docket class that accepts parameter DocumentationType
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2);
    }
}


//http://localhost:8080/v2/api-docs

//http://localhost:8080/swagger-ui.html#/
