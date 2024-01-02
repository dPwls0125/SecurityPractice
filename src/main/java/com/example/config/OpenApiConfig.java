package com.example.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI OpenApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("Dragon project OpenApi")
                        .description(".")
                        .version("V0.0.1")
                        .contact(new Contact()
                                        .name("phoby")
//                                .email("")
                        ));
//                .externalDocs(new ExternalDocumentation()
//                        .description("Mango Github")
//                        .url("https://github.com/ManGoTeam3"));
    }

}