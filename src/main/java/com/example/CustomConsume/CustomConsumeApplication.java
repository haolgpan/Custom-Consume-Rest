package com.example.CustomConsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomConsumeApplication {
	private static final Logger log = LoggerFactory.getLogger(CustomConsumeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomConsumeApplication.class, args);
	}
}
