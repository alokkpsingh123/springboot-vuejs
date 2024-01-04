package com.example.demo;

import com.example.demo.controller.FoodController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication {

	/**
	 *
	 * @param args
	 * starting point of spring boot application
	 */

	public static void main(String[] args) {

		System.out.println("Before creating the spring context");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("After creating the spring context");

	}

}
