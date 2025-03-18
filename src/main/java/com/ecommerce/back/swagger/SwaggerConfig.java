package com.ecommerce.back.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	//Esto es una prueba
	@Bean
	public OpenAPI custonOpenAPI() {
		return new OpenAPI().info(new Info().title("API Ecommerce")
											.version("1.0.0")
											.description("Esta documentación es para el backend API REST de ecommerce, hecho con Java 17, Spring Boot y MongoDB Atlas como base de datos"));
	}
}
