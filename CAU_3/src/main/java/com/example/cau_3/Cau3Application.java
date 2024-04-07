package com.example.cau_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cau3Application {

    public static void main(String[] args) {
        SpringApplication.run(Cau3Application.class, args);
    }

}
