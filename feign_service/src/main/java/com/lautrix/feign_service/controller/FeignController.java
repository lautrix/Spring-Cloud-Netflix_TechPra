package com.lautrix.feign_service.controller;

import com.lautrix.feign_service.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getConfigContent(){
        return feignService.getConfigContent();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String getConfigValue(){
        return feignService.getConfigValue();
    }
}
