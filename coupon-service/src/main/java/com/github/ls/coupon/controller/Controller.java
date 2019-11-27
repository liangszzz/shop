package com.github.ls.coupon.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.service.CouponService;
import com.github.ls.coupon.vo.ConsumerCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Validated
@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "api/v1/coupon", consumes = {"application/json"})
public class Controller {

    private final CouponService couponService;

    public Controller(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/add")
    public ResponseData add(@RequestBody Coupon coupon) {
        return couponService.add(coupon);
    }

    @PostMapping("/addNumber")
    public ResponseData addNumber(@NotBlank @RequestParam("coupon_no") String couponNo, @Min(value = 1) @RequestParam("number") Long number) {
        return couponService.addNumber(couponNo, number);
    }

    @PostMapping("/del")
    public ResponseData delGoods(@NotBlank @RequestParam("coupon_no") String couponNo) {
        return couponService.del(couponNo);
    }

    @PostMapping("/consumer")
    public ResponseData consumer(@RequestBody ConsumerCoupon consumerCoupon) {
        return couponService.consumer(consumerCoupon.getCoupons(), consumerCoupon.getOrderNo());
    }
}
