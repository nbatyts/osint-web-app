package org.example.osintwebapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OsintWebAppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("BEARER_TOKEN", dotenv.get("BEARER_TOKEN"));

		SpringApplication.run(OsintWebAppApplication.class, args);
	}

}
