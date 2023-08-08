package com.Ujjwal.SpringBoot.demoSecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController{
    @GetMapping("/showMyLoginPage")
    public String showMyloginPage(){
//        return "plain-login";
        return "fancy-login";
    }


//    Mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
//        return "plain-login";
        return "accessdenied";
    }

}
