package com.whoisUjjwal.springcodeDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements  Coach{

    @Lazy
    FootBallCoach(){
        System.out.println("FootBall Coach "+this.getClass().getName());
    }
    @Override
    public String getDailyWorkout() {

        return "Practise Football...";
    }
}
