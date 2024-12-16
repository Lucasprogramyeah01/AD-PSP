package com.example.monumentosV2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(description = "Una API de monumentos realizada en 2º DAM",
		version = "3.0",
		contact = @Contact(
				email = "falla.urluc24@triana.salesianos.edu",
				name = "Lucas Falla Urtiaga"),
		license = @License(
				name = "Kalise para todos"),
		title = "API sobre monumentos")
)
public class MonumentosV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MonumentosV2Application.class, args);
	}

}
