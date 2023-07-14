package com.whoisUjjwal.springcodeDemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run in the Field for 200 Meters.";
    }
}
