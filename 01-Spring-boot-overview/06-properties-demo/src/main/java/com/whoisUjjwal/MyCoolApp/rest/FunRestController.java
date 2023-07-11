package com.whoisUjjwal.MyCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {

//  Inject properties for : Coach.name and team.name

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;


//    Expose new endpoint for "Team Info"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "<h1>Coach name "+coachName+"Team Name "+teamName+"</h1>";
    }

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
