package com.example.orchestration.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Secure API Orchestration")
                        .version("1.0.0")
                        .description("Demo project to showcase secure, orchestrated APIs using Spring Boot and MongoDB."));
    }
}