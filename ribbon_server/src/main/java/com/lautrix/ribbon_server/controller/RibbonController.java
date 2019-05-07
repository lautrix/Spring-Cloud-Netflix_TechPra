package com.lautrix.ribbon_server.controller;

import com.lautrix.ribbon_server.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;

    @RequestMapping("/")
    public String getRibbonContent(){
        return ribbonService.getRibbonContent();
    }

    @RequestMapping("/config")
    public String getConfigValue(){
        return ribbonService.getConfigValue();
    }
}
