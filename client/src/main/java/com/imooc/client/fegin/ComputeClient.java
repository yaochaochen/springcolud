package com.imooc.client.fegin;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("compute-service")
public interface ComputeClient {
    
    @GetMapping("/add")
    Integer add(@RequestParam Integer a, @RequestParam Integer b);


    @Component
     class ComputeClientHystrix implements ComputeClient {

        @Override
        public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
            return -9999;
        }

    }
}
