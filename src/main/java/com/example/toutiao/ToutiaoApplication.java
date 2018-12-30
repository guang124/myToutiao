package com.example.toutiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.toutiao.mapper"})
public class ToutiaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToutiaoApplication.class, args);
    }

}

