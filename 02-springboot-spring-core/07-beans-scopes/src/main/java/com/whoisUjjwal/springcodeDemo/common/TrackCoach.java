package com.whoisUjjwal.springcodeDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Lazy
    TrackCoach(){
        System.out.println("Track Coach "+this.getClass().getName());
    }
    @Override

    public String getDailyWorkout() {

        return "Run in the Field for 200 Meters.";
    }
}
