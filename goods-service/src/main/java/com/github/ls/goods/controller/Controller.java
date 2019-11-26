package com.github.ls.goods.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.base.Goods;
import com.github.ls.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/add")
    public ResponseData addGoods(@RequestBody Goods goods) {
        return goodsService.addGoods(goods);
    }

    @PostMapping("/addNumber")
    public ResponseData addGoodsNumber(@NotBlank @RequestParam("goods_id") String goodsId, @Min(value = 1) @RequestParam("number") Long number) {
        return goodsService.addGoodsNumber(goodsId, number);
    }

    @PostMapping("/del")
    public ResponseData delGoods(@NotBlank @RequestParam("goods_id") String goodsId) {
        return goodsService.delGoods(goodsId);
    }

    @PostMapping("/consumer")
    public ResponseData consumerGoods(@NotNull @RequestParam("goods") List<Goods> goods, @NotBlank @RequestParam("order_no") String orderNo) {
        return goodsService.consumerGoods(goods, orderNo);
    }

}
