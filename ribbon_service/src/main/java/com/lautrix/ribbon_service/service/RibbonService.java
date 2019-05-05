package com.lautrix.ribbon_service.service;

import com.lautrix.ribbon_service.utils.ApiConfig;
import com.lautrix.ribbon_service.utils.DomainConfig;
import com.lautrix.ribbon_service.utils.URLConstructor;
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
        // url中的值不能包含下划线。如：SERVICE-CLIENT_1 这种配置非法。
        String url = URLConstructor.url(DomainConfig.ServiceClient, ApiConfig.GetContent);
        System.out.println(">>>>>>>>>>>>>>:"+url);
        return restTemplate.getForObject(url,String.class);
    }

    @HystrixCommand(fallbackMethod = "callFailure")
    public String getConfigValue(){
        return restTemplate.getForObject("http://SERVICE-CLIENT/config",String.class);
    }

    public String callFailure(){
        return "service is not available, please try it latter!";
    }
}
