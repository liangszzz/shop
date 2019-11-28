package com.github.ls.coupon.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "api/v1/coupon", consumes = {"application/json"})
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("add")
    public ResponseData add(@Valid @RequestBody Coupon coupon) {
        return couponService.add(coupon);
    }

    @PostMapping("/update")
    public ResponseData update(@Valid @RequestBody Coupon coupon) {
        return couponService.update(coupon);
    }

    @PostMapping("/del")
    public ResponseData delGoods(@NotBlank @RequestParam("coupon_no") String couponNo) {
        return couponService.del(couponNo);
    }

}
