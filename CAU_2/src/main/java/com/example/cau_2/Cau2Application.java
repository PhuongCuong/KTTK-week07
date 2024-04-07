package com.example.cau_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class Cau2Application {

    public static void main(String[] args) {
        SpringApplication.run(Cau2Application.class, args);
    }

}
