package com.github.ls.order.dao;

import com.github.ls.common.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(value = "spring-cloud-coupon")
public interface CouponDao {

    @PostMapping("use")
    ResponseData use(@RequestParam String order_no,@RequestParam String coupon_no);

}
