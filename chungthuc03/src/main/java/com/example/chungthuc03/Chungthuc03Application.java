package com.example.chungthuc03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Chungthuc03Application {

	public static void main(String[] args) {
		SpringApplication.run(Chungthuc03Application.class, args);
	}

}
