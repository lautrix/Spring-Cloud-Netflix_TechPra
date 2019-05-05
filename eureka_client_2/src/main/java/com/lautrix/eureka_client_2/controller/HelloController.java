package com.lautrix.eureka_client_2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @RequestMapping("/")
    public String HelloEureka() {
        return "Hello eureka client 2!";
    }

    @Value("${iname}")
    private String name;

    @RequestMapping("/config")
    public String getConfigValue() {
        return "eureka client 2:"+name;
    }
}
