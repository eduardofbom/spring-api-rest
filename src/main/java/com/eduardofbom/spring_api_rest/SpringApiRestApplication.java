package com.eduardofbom.spring_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiRestApplication.class, args);
	}

}
