package com.github.ls.coupon.feign;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.fallback.UserCouponFeignDaoFallback;
import com.github.ls.coupon.vo.ConsumerCoupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Primary
@FeignClient(value = "spring-cloud-coupon", fallback = UserCouponFeignDaoFallback.class)
public interface UserCouponFeignDao {

    @PostMapping(value = "api/v1/coupon/user/consumer", consumes = "application/json")
    ResponseData consumer(@Valid @RequestBody ConsumerCoupon consumerCoupon);

    @PostMapping(value = "api/v1/coupon/user/rollback", consumes = "application/json")
    ResponseData rollback(@NotBlank @RequestParam("order_no") String orderNo);

}
