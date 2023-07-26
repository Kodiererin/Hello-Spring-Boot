package com.UjjwalSpring.demo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class DemoRestController {

//    Add for for the "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello (){
        return "Hello World";
    }
}
