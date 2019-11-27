package com.github.ls.coupon.fallback;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.feign.CouponDao;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class CouponDaoFallback implements CouponDao {
    @Override
    public ResponseData consumerGoods(@NotNull List<Coupon> coupons, @NotBlank String orderNo) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }
}
