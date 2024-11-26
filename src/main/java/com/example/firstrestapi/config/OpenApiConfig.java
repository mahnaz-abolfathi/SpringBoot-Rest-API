package com.example.firstrestapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * configuration to define open api specification
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI accountsBackendOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Customers Backend API ")
                        .description("Provide Customer Management")
                        .version("1.0"));
    }
}
