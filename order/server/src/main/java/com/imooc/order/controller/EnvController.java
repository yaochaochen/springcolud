package com.imooc.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaochaochen
 * 2018-01-21 21:57
 */
@RestController
@RequestMapping("/env")
public class EnvController {

//    @Value("${env}")
//    private String env;

    @GetMapping("/print")
    private String print() {
        return "hello";
    }
}
