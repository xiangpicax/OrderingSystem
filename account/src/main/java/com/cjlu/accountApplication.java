package com.cjlu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.cjlu.service")
public class accountApplication {
    public static void main(String[] args) {
        SpringApplication.run(accountApplication.class,args);
    }
}
