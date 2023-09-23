package com.ujjwal.AOPDemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyCloudAsyncAspect {



    @Pointcut("execution(* com.ujjwal.AOPDemo.dao.*.*(..))")
    public void forDAOPackage(){

    }


    //        Create a pointcut for getter method.
    @Pointcut("execution(* com.ujjwal.AOPDemo.dao.*.get*(..))")
    public void getter(){

    }

    //        Create a pointcut for setter method.
    @Pointcut("execution(* com.ujjwal.AOPDemo.dao.*.set*(..))")
    public void setter(){

    }

    //        Create a pointcut : Include package exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOpakageExcludeGetterAndSetter(){

    }
}
