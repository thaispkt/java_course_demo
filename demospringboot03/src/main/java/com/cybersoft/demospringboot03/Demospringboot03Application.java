package com.cybersoft.demospringboot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Nếu muốn tạo ra class gán sẵn giá trị và sử dụng lại class này cho class khác thì phải đưa class
 này lưu trữ trên container (IOC), thông qua annotation @Bean, @Service, @Component, @Repository
 */
@SpringBootApplication
public class Demospringboot03Application {

	public static void main(String[] args) {
		SpringApplication.run(Demospringboot03Application.class, args);
	}

}
