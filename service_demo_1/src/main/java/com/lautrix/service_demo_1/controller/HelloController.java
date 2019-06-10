package com.lautrix.service_demo_1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class HelloController {
    @RequestMapping("/")
    public String HelloEureka() {
        return "Hello Service_Demo_1!";
    }

//    @Value("${iname}")
//    private String name;

    @RequestMapping("/config")
    public String config() {
        String name = "/config";
        return "Service_Demo_1"+name;
    }
}
