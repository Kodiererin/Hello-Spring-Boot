package com.whoisUjjwal.springcodeDemo.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise Bowling..";
    }
}
