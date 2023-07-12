package com.whoisUjjwal.springcodeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//	As Coach Class and Cricket coach was moved into another package so, Spring Boot couldnot automatically scan the components
//	So, We explecitely said the Class to scan these components.
@SpringBootApplication(
		scanBasePackages = {"com.whoisUjjwal.util" ,
		"com.whoisUjjwal.springcodeDemo"}
)

public class SpringcodeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcodeDemoApplication.class, args);
	}

}
