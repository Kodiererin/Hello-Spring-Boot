package com.whoisUjjwal.springcodeDemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    public void CricketCoach(){
        System.out.println("Cricket Coach "+this.getClass().getName());
    }

//    define our inti method
    @PostConstruct
    public void doMyStartUp(){
        System.out.println("In DO my Startup Method"+getClass().getSimpleName());
    }

//    define our destroy method
    @PreDestroy
    public void doCleanup(){
        System.out.println("In DO my CleanUp/Destroy Method"+getClass().getSimpleName());
    }



    @Override
    public String getDailyWorkout() {

        return "Practise Bowling..";
    }
}
