package com.imooc.client.controller;

import com.imooc.client.fegin.ComputeClient;
import com.imooc.client.service.ComputeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ComputeController
 * @Author yaochaochen
 * @Date 2019-04-11 13:45
 **/

@RestController
public class ComputeController {

    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private DiscoveryClient client;
    
    @Autowired 
    private ComputeClient computeClient;
    
    @Autowired
    private ComputeService computeService;
    
    @GetMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + a+b);
        return a+b;
    }
    
    @GetMapping("/client/add")
    public Integer adds() {
        return computeClient.add(10, 20);
    }

    @GetMapping("/client/add")
    public String add() {
        return computeService.addService();
    }
}
