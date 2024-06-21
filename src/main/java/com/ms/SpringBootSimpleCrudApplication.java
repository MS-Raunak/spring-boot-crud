package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSimpleCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSimpleCrudApplication.class, args);
		System.out.println("Server Started");
	}

}
