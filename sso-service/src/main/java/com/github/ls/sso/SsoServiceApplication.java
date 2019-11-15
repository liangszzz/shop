package com.github.ls.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EntityScan(basePackages = "com.github.ls.ssoservice.entity")
@SpringBootApplication
public class SsoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoServiceApplication.class, args);
    }

}
