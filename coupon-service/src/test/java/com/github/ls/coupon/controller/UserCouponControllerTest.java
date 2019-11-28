package com.github.ls.coupon.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@DisplayName("用户优惠券测试")
@SpringBootTest
@AutoConfigureMockMvc
public class UserCouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    public void add() {

    }
}