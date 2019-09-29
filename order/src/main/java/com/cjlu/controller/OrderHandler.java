package com.cjlu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    String port;

    @GetMapping("/index")
    public String index(){
        return "端口号是："+this.port;
    }
}
