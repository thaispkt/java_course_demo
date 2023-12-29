package com.example.gateway03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway03Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway03Application.class, args);
	}

}
