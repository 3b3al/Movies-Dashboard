package com.moviesdashboard.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SecurityScheme(
    name = "Authorization",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)
@OpenAPIDefinition(
    info = @Info(title = "My API", version = "v1"),
    security = @SecurityRequirement(name = "Authorization")
)
@Configuration
public class SwaggerConfig {
    // @Bean
    // public Docket api() {
    //     return new Docket(DocumentationType.OAS_30)
    //             .select()
    //             .apis(RequestHandlerSelectors.any())
    //             .paths(PathSelectors.any())
    //             .build()
    //             .useDefaultResponseMessages(false);
    // }

    
}
