package com.lautrix.ribbon_server.service;

import com.lautrix.ribbon_server.utils.ApiConfig;
import com.lautrix.ribbon_server.utils.DomainConfig;
import com.lautrix.ribbon_server.utils.URLConstructor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callFailure")
    public String getRibbonContent(){
        // url中的值不能包含下划线。如：SERVICE-DEMO_1 这种配置非法.但是可以包含连接线-
        String url = URLConstructor.url(DomainConfig.ServiceClient, ApiConfig.GetContent);
        Object object = null;
        return restTemplate.getForObject(url,String.class);
    }

    @HystrixCommand(fallbackMethod = "callFailure")
    public String getConfigValue(){
        String url = URLConstructor.url(DomainConfig.ServiceClient, ApiConfig.GetConfig);
        return restTemplate.getForObject(url,String.class);
    }

    public String callFailure(){
        return "service is not available, please try it latter!";
    }
}
