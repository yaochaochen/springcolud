package com.yuetu.alibabanacosdiscoveryclientcommon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryClientCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
    }
    
    @Slf4j
    @RestController
    static class TestController {
        
        @Autowired
        LoadBalancerClient loadBalanced;
        
        @GetMapping("/test")
         public String test() {

            ServiceInstance serviceInstance = loadBalanced.choose("");
            String url = serviceInstance.getUri() + "/hello?name=" +"did";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class );
            return "Invoke :" + url + "return" + result;
            
        }
        
    }

}
