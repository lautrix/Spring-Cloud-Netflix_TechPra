package com.lautrix.ribbon_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    public String getRibbonContent(){
        // url中的值不能包含下划线。如：SERVICE-CLIENT_1 这种配置非法。
        return restTemplate.getForObject("http://SERVICE-CLIENT/",String.class);
    }

    public String getConfigValue(){
        return restTemplate.getForObject("http://SERVICE-CLIENT/config",String.class);
    }
}
