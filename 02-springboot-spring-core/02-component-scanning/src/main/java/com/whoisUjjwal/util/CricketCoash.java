package com.whoisUjjwal.util;

import org.springframework.stereotype.Component;

@Component              // This annotation marks the coamponent for Spring Bran
public class CricketCoash implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practise Fast Bowling for 15 minutes....";
    }
}
