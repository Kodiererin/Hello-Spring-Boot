package com.whoisUjjwal.springcodeDemo.common;


import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach  {
    @Override
    public String getDailyWorkout() {
        return "Dribble the Ball 200 Times";
    }
}
