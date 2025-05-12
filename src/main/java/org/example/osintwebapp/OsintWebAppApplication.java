package org.example.osintwebapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsintWebAppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("BEARER_TOKEN", dotenv.get("BEARER_TOKEN"));
		System.setProperty("HUNTER_API_KEY", dotenv.get("HUNTER_API_KEY"));

		SpringApplication.run(OsintWebAppApplication.class, args);
	}

}
