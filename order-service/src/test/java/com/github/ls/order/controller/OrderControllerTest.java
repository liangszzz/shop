package com.github.ls.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.goods.entity.Goods;
import com.github.ls.order.dao.vo.OrderSubmitVO;
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

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("订单测试")
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private final String goodsNo = "768c636f-f929-463d-a5e3-a875e85ec78a";
    private final String couponNo = "df573cb9-9f4f-45b3-8910-dcee8db308a9";

    @DisplayName("提交订单")
    @Test
    public void submit() throws Exception {

        OrderSubmitVO vo = OrderSubmitVO.builder().
                good(Goods.builder()
                        .goodsNo(goodsNo)
                        .goodsName("goods_name")
                        .goodsPrice(new BigDecimal("20.0"))
                        .goodsNumber(1L)
                        .build()).
                coupon(UserCoupon.builder()
                        .couponNo(couponNo)
                        .couponNumber(1L)
                        .username("user")
                        .couponAmount(new BigDecimal("1"))
                        .build())
                .build();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/order/submit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(vo));

        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }
}