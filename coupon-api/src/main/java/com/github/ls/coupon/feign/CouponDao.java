package com.github.ls.coupon.feign;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@FeignClient(value = "spring-cloud-coupon")
public interface CouponDao {

    @PostMapping("api/v1/coupon/consumer")
    ResponseData consumerGoods(@NotNull @RequestParam("coupons") List<Coupon> coupons,
                               @NotBlank @RequestParam("order_no") String orderNo);

}
