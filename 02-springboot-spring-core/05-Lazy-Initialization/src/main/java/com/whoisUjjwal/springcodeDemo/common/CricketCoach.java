package com.whoisUjjwal.springcodeDemo.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    @Lazy
    CricketCoach(){
        System.out.println("Cricket Coach "+this.getClass().getName());
    }
    @Override
    public String getDailyWorkout() {

        return "Practise Bowling..";
    }
}
