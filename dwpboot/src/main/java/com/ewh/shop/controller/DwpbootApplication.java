package com.ewh.shop.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class}) 
@ComponentScan(basePackages= {"com.ewh.shop", "com.example.demo"})

public class DwpbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DwpbootApplication.class, args);
	}
}
