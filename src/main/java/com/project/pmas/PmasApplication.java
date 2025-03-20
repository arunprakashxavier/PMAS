package com.project.pmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "PMAS API", version = "1.0", description = "Project Management API"))
public class PmasApplication {
	public static void main(String[] args) {
		SpringApplication.run(PmasApplication.class, args);
	}
}
