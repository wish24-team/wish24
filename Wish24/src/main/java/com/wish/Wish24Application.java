package com.wish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Wish24Application {

	public static void main(String[] args) {
		SpringApplication.run(Wish24Application.class, args);
	}

}
