package com.lautrix.feign_service.service.impl;

import com.lautrix.feign_service.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFailureServiceImpl implements FeignService {

    @Override
    public String getConfigContent(){
        return "service is not available, please try it latter!";
    }

    @Override
    public String getConfigValue(){
        return "service is not available, please try it latter!";
    }
}
