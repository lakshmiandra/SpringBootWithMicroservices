package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext config =	SpringApplication.run(DemoApplication.class, args);
		
		//Alien a = new Alien();  // we should use new to create object it's kind of tight coupling
		
		Alien a = config.getBean(Alien.class);
		a.Show();
				
		
	}

}
