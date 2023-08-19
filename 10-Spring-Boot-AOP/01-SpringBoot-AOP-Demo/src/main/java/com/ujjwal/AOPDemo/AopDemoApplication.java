package com.ujjwal.AOPDemo;

import com.ujjwal.AOPDemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO){
		return  runner ->{

			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
//		Call the business Method
		theAccountDAO.addAccount();

//		Do it again
		System.out.println("\n Lets call it agaain \n");

//		Call the Business Method One More time

		theAccountDAO.addAccount();
	}
}
