package com.acme.learningcenter.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(
            @Value("${documentation.application.description}")
            String applicationDescription,
            @Value("${documentation.application.version}")
            String applicationVersion
    ) {
        return new OpenAPI()
                .info(new Info()
                        .title("ACME Learning Center API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://acme-learning.com/tos")
                        .license(new License()
                                .name("Apache 2.0 License")
                                .url("https://acme-learning.com/license"))
                        .contact(new Contact()
                                .url("https://acme.studio")
                                .name("ACME,.studio")));

    }
}
