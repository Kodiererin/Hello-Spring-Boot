package com.whoisUjjwal.springcodeDemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "Practise Football...";
    }
}
