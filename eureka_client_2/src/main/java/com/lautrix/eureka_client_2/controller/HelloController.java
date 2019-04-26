package com.lautrix.eureka_client_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String HelloEureka(){
        return "Hello Eureka!";
    }
}
