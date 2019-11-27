package com.github.ls.coupon.fallback;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.coupon.feign.CouponDao;
import com.github.ls.coupon.vo.ConsumerCoupon;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class CouponDaoFallback implements CouponDao {

    @Override
    public ResponseData consumer(ConsumerCoupon consumerCoupon) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }

    @Override
    public ResponseData rollback(@NotBlank String orderNo) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }
}
