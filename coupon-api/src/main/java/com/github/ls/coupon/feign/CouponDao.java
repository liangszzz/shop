package com.github.ls.coupon.feign;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.fallback.CouponDaoFallback;
import com.github.ls.coupon.vo.ConsumerCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

@Primary
@FeignClient(value = "spring-cloud-coupon", fallback = CouponDaoFallback.class)
public interface CouponDao {

    @PostMapping("api/v1/coupon/consumer")
    ResponseData consumer(@RequestBody ConsumerCoupon consumerCoupon);

    @PostMapping("api/v1/coupon/rollback")
    ResponseData rollback(@NotBlank @RequestParam("order_no") String orderNo);

}
