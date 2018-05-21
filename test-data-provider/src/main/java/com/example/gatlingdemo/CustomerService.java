package com.example.gatlingdemo;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CustomerService {

	public Mono<String> customerId() {
		return webClient().get()
						  .uri("/customers")
						  .exchange()
						  .timeout(Duration.ofSeconds(10))
						  .flatMap(c -> c.bodyToMono(String.class));
	}

	private WebClient webClient() {
		return WebClient.builder()
						.baseUrl("http://localhost:8080")
						.defaultHeader(HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
						.defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
						.build();
	}
}
