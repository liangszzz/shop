package com.github.ls.coupon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.UserCoupon;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@DisplayName("用户优惠券测试")
@SpringBootTest
@AutoConfigureMockMvc
public class UserCouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper mapper;

    private static final String no = "cacf63a2-cb1c-47e6-bbc7-9819e4c32ec3";

    private UserCoupon userCoupon;

    @BeforeAll
    public static void beforeAll() {
        mapper = new ObjectMapper();
    }

    @BeforeEach
    public void beforeEach() {
        userCoupon = new UserCoupon();
        userCoupon.setCouponNo(no);
        userCoupon.setCouponNumber(100L);
        userCoupon.setUsername("user");
    }

    @DisplayName("添加用户优惠券")
    @Order(1)
    @Test
    public void add() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userCoupon));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("删除用户优惠券")
    @Order(5)
    @Test
    public void del() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/user/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userCoupon));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }
}