package com.yuetu;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosDiscoveryServerApplication.class, args);
    }



    // 注入 Nacos 的 NamingService 实例
    @NacosInjected
    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @PostConstruct
    public void registerInstance() throws NacosException {
        // 通过Nacos Open API 向 Nacos Server 注册一个名称为applicationName的服务
        // curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=XXX&ip=XXX&port=XXX'

        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
    }
    
    @Slf4j
    @RestController
    static class TestController {

        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("Invoke name = ", name);
            return "hello" + name;

        }

    }
   
    
}