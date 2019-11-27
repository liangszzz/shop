package com.github.ls.goods.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
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
    public ResponseData add(@RequestBody Goods goods) {
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
    public ResponseData consumer(@NotNull @RequestParam("goods") List<Goods> goods, @NotBlank @RequestParam("order_no") String orderNo) {
        return goodsService.consumer(goods, orderNo);
    }

}
