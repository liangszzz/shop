package com.github.ls.coupon.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.coupon.service.UserCouponService;
import com.github.ls.coupon.vo.ConsumerCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Validated
@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "api/v1/coupon/user", consumes = {"application/json"})
public class UserCouponController {

    private final UserCouponService userCouponService;

    public UserCouponController(UserCouponService userCouponService) {
        this.userCouponService = userCouponService;
    }

    @PostMapping("/add")
    public ResponseData add(@RequestBody UserCoupon coupon) {
        return userCouponService.add(coupon);
    }

    @PostMapping("/update")
    public ResponseData update(@RequestBody UserCoupon userCoupon) {
        return userCouponService.updateUserCoupon(userCoupon);
    }

    @PostMapping("/del")
    public ResponseData del(@RequestBody UserCoupon userCoupon) {
        return userCouponService.del(userCoupon);
    }

    @PostMapping("/consumer")
    public ResponseData consumer(@RequestBody ConsumerCoupon consumerCoupon) {
        return userCouponService.consumer(consumerCoupon.getCoupons(), consumerCoupon.getOrderNo());
    }

    @PostMapping("/rollback")
    public ResponseData rollback(@NotBlank @RequestParam("order_no") String orderNo) {
        userCouponService.rollbackOrder(orderNo);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }
}
