package com.example.gatlingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
public class GatlingdemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(GatlingdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GatlingdemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		LOGGER.info("Request at: ({})", LocalDateTime.now());
		return "hello";
	}
}
