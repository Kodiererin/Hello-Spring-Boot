package com.ujjwal.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAPIAnalytics {

    @Before("forDAOpakageExcludeGetterAndSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====> Executing @Before advice on AddAcount()  <===============");
    }


}
