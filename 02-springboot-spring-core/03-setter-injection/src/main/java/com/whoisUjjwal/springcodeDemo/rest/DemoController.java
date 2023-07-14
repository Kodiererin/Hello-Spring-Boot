package com.whoisUjjwal.springcodeDemo.rest;

import com.whoisUjjwal.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    Define a privtate field for Dependency
    private Coach myCoach;
//    Define a Constructor for Dependency Injection
    @Autowired
    DemoController(Coach theCoach){
        myCoach = theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }
}
