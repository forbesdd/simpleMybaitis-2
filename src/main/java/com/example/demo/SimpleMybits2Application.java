package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SimpleMybits2Application {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMybits2Application.class, args);
	}

}
