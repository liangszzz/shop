package com.github.ls.coupon.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.coupon.dao.CouponDao;
import com.github.ls.coupon.dao.OrderCouponDao;
import com.github.ls.coupon.entity.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Transactional(rollbackOn = RuntimeException.class)
@Slf4j
@Service
public class CouponService {

    private final CouponDao couponDao;

    private final OrderCouponDao orderCouponDao;

    public CouponService(CouponDao couponDao, OrderCouponDao orderCouponDao) {
        this.couponDao = couponDao;
        this.orderCouponDao = orderCouponDao;
    }

    public ResponseData add(Coupon coupon) {
        coupon.setCreateDateTime(LocalDateTime.now());
        coupon.setCouponStatus(0);
        couponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData update(Coupon coupon) {
        Coupon c = couponDao.findByCouponNoAndCouponStatus(coupon.getCouponNo(), 0)
                .orElseThrow(DataNotFoundException::new);
        c.setCouponAmount(coupon.getCouponAmount());
        c.setCouponName(coupon.getCouponName());
        couponDao.save(c);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData del(String couponNo) {
        Coupon coupon = couponDao.findByCouponNoAndCouponStatus(couponNo, 0).orElseThrow(DataNotFoundException::new);
        coupon.setCouponStatus(1);
        couponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

}
