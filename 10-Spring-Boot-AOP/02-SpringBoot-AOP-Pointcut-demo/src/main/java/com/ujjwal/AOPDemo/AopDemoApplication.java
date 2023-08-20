package com.ujjwal.AOPDemo;

import com.ujjwal.AOPDemo.dao.AccountDAO;
import com.ujjwal.AOPDemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO , MembershipDAO theMembershipDAO){
		return  runner ->{

			demoTheBeforeAdvice(theAccountDAO , theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO , MembershipDAO theMembershipDAO) {
//		Call the business Method
		Account theAccount = new Account();
//		theAccountDAO.addAccount(theAccount);
		theAccountDAO.addAccount(theAccount , true);
		theAccountDAO.helloUjjwal();

//		call the membership business method
		theMembershipDAO.addAccount();





//		Do it again
//		System.out.println("\n Lets call it agaain \n");

//		Call the Business Method One More time

//		theAccountDAO.addAccount();
	}
}
