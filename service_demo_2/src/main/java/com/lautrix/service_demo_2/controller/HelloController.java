package com.lautrix.service_demo_2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @RequestMapping("/")
    public String HelloEureka() {
        return "Hello Service_Demo_2!";
    }

    @Value("${iname}")
    private String name;

    @RequestMapping("/config")
    public String getConfigValue() {
        return "Service_Demo_2:"+name;
    }
}
