package com.imooc.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ComputeService
 * @Author yaochaochen
 * @Date 2019-04-11 14:03
 **/

@Service
public class ComputeService {
    
    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }
}
