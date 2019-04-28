package com.lautrix.feign_service.service;

import com.lautrix.feign_service.service.impl.FeignFailureServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SERVICE-CLIENT", fallback = FeignFailureServiceImpl.class)
public interface FeignService {
    @RequestMapping("/")
    public String getConfigContent();

    @RequestMapping("/config")
    public String getConfigValue();
}
