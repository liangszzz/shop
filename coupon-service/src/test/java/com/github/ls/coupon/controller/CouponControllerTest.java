package com.github.ls.coupon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.CouponServiceApplication;
import com.github.ls.coupon.entity.Coupon;
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

import java.math.BigDecimal;
import java.util.UUID;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("优惠券测试")
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Coupon coupon;

    private static ObjectMapper mapper;

    private static String no;

    @BeforeEach
    public void before() {
        Coupon tmp = new Coupon();
        tmp.setCouponNo(no);
        tmp.setCouponName("coupon_001_name");
        tmp.setCouponAmount(new BigDecimal("1.0"));
        coupon = tmp;
        log.error("exec before");
    }

    @Order(1)
    @DisplayName("优惠券添加")
    @Test
    public void add() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(coupon));
        MvcResult result = mockMvc.perform(request).andReturn();
        ResponseData responseData = mapper.readValue(result.getResponse().getContentAsString(), ResponseData.class);
        Assertions.assertEquals(responseData.getCode(), ResponseCode.SUCCESS);
    }

    @Order(2)
    @DisplayName("优惠券修改")
    @Test
    public void update() throws Exception {
        coupon.setCouponName("coupon_002_name");
        coupon.setCouponAmount(new BigDecimal("200.00"));
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(coupon));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        ResponseData responseData = mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class);
        Assertions.assertEquals(responseData.getCode(), ResponseCode.SUCCESS);
    }

    @Order(3)
    @DisplayName("优惠券删除")
    @Test
    public void del() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/coupon/del")
                .contentType(MediaType.APPLICATION_JSON)
                .param("coupon_no", no);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        ResponseData responseData = mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class);
        Assertions.assertEquals(responseData.getCode(), ResponseCode.SUCCESS);
    }

    @BeforeAll
    public static void beforeAll() {
        no = UUID.randomUUID().toString();
        mapper = new ObjectMapper();
        log.error("exec before all");
    }
}