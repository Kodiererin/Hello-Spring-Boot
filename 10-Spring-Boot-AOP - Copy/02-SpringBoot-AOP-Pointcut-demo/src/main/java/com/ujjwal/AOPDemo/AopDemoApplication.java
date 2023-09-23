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
		//	Call the account DAO getter/setter
		theAccountDAO.setServiceCode("Helllo");
		theAccountDAO.setName("World");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		return  runner ->{

			demoTheBeforeAdvice(theAccountDAO , theMembershipDAO);
		};
	}



	private void demoTheBeforeAdvice(AccountDAO theAccountDAO , MembershipDAO theMembershipDAO) {
		Account theAccount = new Account();
		theAccountDAO.addAccount(theAccount , true);
		theAccountDAO.helloUjjwal();
		theMembershipDAO.addAccount();
	}
}
