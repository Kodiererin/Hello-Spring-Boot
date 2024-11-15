package com.Ujjwal.SpringBoot.demoSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome(){
        return "/home";
    }

//    Add another request mapping for Leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

//    Add request mapping for /systems
@GetMapping("/systems")
public String showSystems(){
    return "systems";
}
}
