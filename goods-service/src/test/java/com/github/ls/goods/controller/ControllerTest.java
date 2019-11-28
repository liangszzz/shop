package com.github.ls.goods.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.vo.ConsumerGoods;
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

@DisplayName("商品测试")
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String goodsNo = UUID.randomUUID().toString();

    private final String orderNo = UUID.randomUUID().toString();

    private ObjectMapper mapper = new ObjectMapper();

    private Goods goods;

    @BeforeEach
    public void setUp() {
        goods = new Goods();
        goods.setGoodsNo(goodsNo);
        goods.setGoodsNumber(100L);
        goods.setGoodsName("goods_name");
        goods.setGoodsPrice(new BigDecimal("20.0"));
    }

    @DisplayName("添加商品")
    @Order(1)
    @Test
    public void add() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/goods/add")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(goods));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("添加商品库存")
    @Order(2)
    @Test
    public void addNumber() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/goods/addNumber")
                .contentType(MediaType.APPLICATION_JSON)
                .param("goods_no", orderNo)
                .param("number", "100");
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("消费商品")
    @Order(3)
    @Test
    public void consumer() throws Exception {
        goods.setGoodsNumber(1L);
        ConsumerGoods consumerGoods = ConsumerGoods.builder().orderNo(orderNo).good(goods).build();
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/goods/consumer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(consumerGoods));
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("回滚商品")
    @Order(4)
    @Test
    public void rollback() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/goods/rollback")
                .contentType(MediaType.APPLICATION_JSON)
                .param("order_no", orderNo);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }

    @DisplayName("下架商品")
    @Order(5)
    @Test
    public void del() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/api/v1/goods/del")
                .contentType(MediaType.APPLICATION_JSON)
                .param("goods_no", orderNo);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        Assertions.assertEquals(ResponseCode.SUCCESS,
                mapper.readValue(mvcResult.getResponse().getContentAsString(), ResponseData.class).getCode());
    }


}