package com.floreria.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FloreriaAppApplication extends SpringBootServletInitializer implements CommandLineRunner {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	
	public static void main(String[] args) {
		SpringApplication.run(FloreriaAppApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FloreriaAppApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
//		String passString = "admin";
//		
//		for (int i = 0; i < 4; i++) {
//			System.out.println(passwordEncoder.encode(passString));
//		}
				
		System.out.println("Start .....");
	}
}
