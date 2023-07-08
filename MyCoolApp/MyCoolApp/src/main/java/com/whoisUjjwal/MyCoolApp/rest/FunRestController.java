package com.whoisUjjwal.MyCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FunRestController {


//    Expose a "/" endpoint that will return the Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
}
