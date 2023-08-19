package com.ujjwal.AOPDemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect  {
//    This is where we add all of our related advices for logging
//    lets start with an @Before Advice.

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before advice on AddAcount()  sssssss");
    }

}
