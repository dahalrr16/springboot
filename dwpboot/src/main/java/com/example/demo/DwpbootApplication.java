package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.ewh.shop", "com.example.demo"})
public class DwpbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwpbootApplication.class, args);
	}
}
