package com.lautrix.feign_server.service;

import com.lautrix.feign_server.service.impl.FeignFailureServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "SERVICE-DEMO", fallback = FeignFailureServiceImpl.class)
public interface FeignService {
    @RequestMapping("/")
    public String getConfigContent();

    @RequestMapping("/config")
    public String getConfigValue();
}
