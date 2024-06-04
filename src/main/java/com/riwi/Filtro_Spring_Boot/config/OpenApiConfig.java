package com.riwi.Filtro_Spring_Boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
            title = "prueba de desempeño",
            version = "1.0",
            description = "Esta es la prueba de desempeño de riwi"
        )
)
public class OpenApiConfig {

}
