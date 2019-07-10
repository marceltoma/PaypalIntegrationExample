package com.example.PaypalDemoStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PaypalDemoStoreApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PaypalDemoStoreApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PaypalDemoStoreApplication.class);
	}
}
