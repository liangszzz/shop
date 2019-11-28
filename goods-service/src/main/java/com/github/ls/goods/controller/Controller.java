package com.github.ls.goods.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.service.GoodsService;
import com.github.ls.goods.vo.ConsumerGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/goods", consumes = {"application/json"})
public class Controller {

    private final GoodsService goodsService;

    public Controller(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/add")
    public ResponseData add(@Valid @RequestBody Goods goods) {
        return goodsService.add(goods);
    }

    @PostMapping("/addNumber")
    public ResponseData addNumber(@NotBlank @RequestParam("goods_no") String goodsNo, @Min(value = 1) @RequestParam("number") Long number) {
        return goodsService.addNumber(goodsNo, number);
    }

    @PostMapping("/del")
    public ResponseData del(@NotBlank @RequestParam("goods_no") String goodsNo) {
        return goodsService.del(goodsNo);
    }

    @PostMapping("/consumer")
    public ResponseData consumer(@Valid @RequestBody ConsumerGoods consumerGoods) {
        return goodsService.consumer(consumerGoods.getGoods(), consumerGoods.getOrderNo());
    }

    @PostMapping("/rollback")
    public ResponseData rollback(@NotBlank @RequestParam("order_no") String orderNo) {
        goodsService.rollBackOrder(orderNo);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

}
