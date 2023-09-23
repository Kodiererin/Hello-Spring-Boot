package com.ujjwal.AOPDemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect  {





//    Reusing Pointcut declaration and using the advice
@Before("forDAOpakageExcludeGetterAndSetter()")
public void performAPIAnalytics(){
    System.out.println("\n=====> Performing API Work <================");
}

    @Before("forDAOpakageExcludeGetterAndSetter()")
    public void logToCloud(){
        System.out.println("\n=====> Logging to Cloud <===============");
    }



    //    Reusing Pointcut declaration and using the advice
    @Before("forDAOpakageExcludeGetterAndSetter()")
    public void logToCloudASYNC(){
        System.out.println("\n=====>  Loggging To Clous ASYNC <================");
    }

}
