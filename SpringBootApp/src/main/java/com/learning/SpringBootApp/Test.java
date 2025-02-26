package com.learning.SpringBootApp;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring App is running");
	}
	

}
