package com.whoisUjjwal.springcodeDemo.rest;
import com.whoisUjjwal.springcodeDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    DemoController(@Qualifier("cricketCoach") Coach theCoach,
                   @Qualifier("cricketCoach") Coach theAnotherCoach){
//        As this is Singeleton so all dependency injections for the bean will reference the Same Bean.
            System.out.println("In Constructr : "+getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }





    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }


    @GetMapping("/check")
    public String check(){
        return "Comparing Beans mycoach==anothercoach "+(myCoach==anotherCoach);
    }
}
