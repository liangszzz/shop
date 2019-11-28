package com.github.ls.coupon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.coupon.dao.CouponDao;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.coupon.vo.ConsumerCoupon;
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

import java.util.List;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@DisplayName("用户优惠券测试")
@SpringBootTest
@AutoConfigureMockMvc
public class UserCouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private final String orderNo = UUID.randomUUID().toString();

    private UserCoupon userCoupon;

    private static String couponNo = "cacf63a2-cb1c-47e6-bbc7-9819e4c32ec3";

    @BeforeEach
    public void beforeEach() {
        userCoupon = new UserCoupon();
        userCoupon.setCouponNo(couponNo);
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

    @DisplayName("消费用户优惠券")
    @Order(3)
    @Test
    public void consumer() throws Exception {
        userCoupon.setCouponNumber(1L);
        ConsumerCoupon consumerCoupon = ConsumerCoupon.builder().orderNo(orderNo).coupon(userCoupon).build();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/user/consumer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(consumerCoupon));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("回滚用户优惠券")
    @Order(4)
    @Test
    public void rollback() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/user/rollback")
                .contentType(MediaType.APPLICATION_JSON)
                .param("order_no", orderNo);
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