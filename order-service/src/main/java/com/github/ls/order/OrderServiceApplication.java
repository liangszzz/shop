package com.github.ls.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.github.ls.order.entity")
@ComponentScan(value = {"com.github.ls"})
public class OrderServiceApplication {

    public static void main(String[] args) {
        System.setProperty("hibernate.dialect.storage_engine","innodb");
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
