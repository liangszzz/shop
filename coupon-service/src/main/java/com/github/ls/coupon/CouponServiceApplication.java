package com.github.ls.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.github.ls.coupon.entity")
@ComponentScan(value = {"com.github.ls"})
public class CouponServiceApplication {

    public static void main(String[] args) {
        System.setProperty("hibernate.dialect.storage_engine", "innodb");
        SpringApplication.run(CouponServiceApplication.class, args);
    }

}
