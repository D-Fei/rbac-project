package com.boss.train.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoginFeignServerApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(LoginFeignServerApplication8002.class, args);
    }

}
