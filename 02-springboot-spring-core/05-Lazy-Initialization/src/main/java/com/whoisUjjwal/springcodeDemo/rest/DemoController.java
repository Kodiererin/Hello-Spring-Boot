package com.whoisUjjwal.springcodeDemo.rest;
import com.whoisUjjwal.springcodeDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    Define a privtate field for Dependency
    private Coach myCoach;
//    Define a Constructor for Dependency Injection
//    @Autowired
//    DemoController(@Qualifier("trackCoach") Coach theCoach){
//        myCoach = theCoach;
//    }


//    Qualifier will start with small lower case even thought the class name starts with UpperCase
//    @Autowired
//    DemoController( Coach theCoach){
//        myCoach = theCoach;
//    }


//    Qualifier has the Higher Priority than Primarry
        @Autowired
    DemoController(@Qualifier("trackCoach") Coach theCoach){
        myCoach = theCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }
}
