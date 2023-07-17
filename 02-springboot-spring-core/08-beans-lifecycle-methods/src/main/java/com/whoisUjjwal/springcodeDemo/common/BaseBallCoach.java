package com.whoisUjjwal.springcodeDemo.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach  {
    @Lazy
    BaseBallCoach(){
        System.out.println("BaseBallCoach   "+this.getClass().getName());
    }
    public String getDailyWorkout() {

        return "Dribble the Ball 200 Times";
    }
}
