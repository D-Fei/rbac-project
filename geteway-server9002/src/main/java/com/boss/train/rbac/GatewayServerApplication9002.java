package com.boss.train.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication9002.class, args);
    }

}
