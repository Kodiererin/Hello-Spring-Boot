package com.whoisUjjwal.springcodeDemo.rest;
import com.whoisUjjwal.springcodeDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    DemoController(@Qualifier("cricketCoach") Coach theCoach){
//        As this is Singeleton so all dependency injections for the bean will reference the Same Bean.
            System.out.println("In Constructr : "+getClass().getSimpleName());
        myCoach = theCoach;
    }







    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }
}
