package com.whoisUjjwal.MyCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {


//    Expose a "/" endpoint that will return the Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello Ujjwal";
    }

//    Expose a new endpoint for "workout"


    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a Hard 5k";
    }

    @GetMapping("/HelloUjjwal")
    public String getUjjwal(){
//       Kem Cho Ujjwal
        return "<h1>Hello Ujjwal How Are You!!!!!!!</h1>";
    }

}
