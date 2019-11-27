package com.github.ls.order.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.goods.entity.Goods;
import com.github.ls.order.service.ShopOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/shop/order", consumes = {"application/json"})
public class OrderController {

    private final ShopOrderService shopOrderService;

    public OrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }


    @PostMapping("submit")
    public ResponseData submit(@NotNull @RequestParam("goods") List<Goods> goods, @NotNull @RequestParam("coupons") List<Coupon> coupons) {
        shopOrderService.submit(goods, coupons);

        return null;
    }


}
