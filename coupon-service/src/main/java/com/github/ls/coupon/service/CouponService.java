package com.github.ls.coupon.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.coupon.dao.CouponDao;
import com.github.ls.coupon.dao.OrderCouponDao;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.entity.OrderCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public ResponseData addNumber(String couponNo, Long number) {
        Coupon coupon = couponDao.findByCouponNoAndCouponStatus(couponNo, 0).orElseThrow(DataNotFoundException::new);
        if (coupon.getCouponNumber() + number >= 0) {
            coupon.setCouponNumber(coupon.getCouponNumber() + number);
            couponDao.save(coupon);
            return ResponseData.builder().code(ResponseCode.SUCCESS).build();
        } else {
            return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg("库存不能小于0").build();
        }
    }

    public ResponseData del(String couponNo) {
        Coupon coupon = couponDao.findByCouponNoAndCouponStatus(couponNo, 0).orElseThrow(DataNotFoundException::new);
        coupon.setCouponStatus(1);
        couponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData consumer(List<Coupon> coupons, String orderNo) {

        List<Coupon> couponConsumers = new ArrayList<>(coupons.size());
        List<OrderCoupon> orderCouponConsumers = new ArrayList<>(coupons.size());

        coupons.forEach(e -> {
            Coupon coupon = couponDao.findByCouponNoAndCouponStatus(e.getCouponNo(), 0).orElseThrow(DataNotFoundException::new);
            if (coupon.getCouponNumber() - e.getCouponNumber() >= 0) {
                coupon.setCouponNumber(coupon.getCouponNumber() - e.getCouponNumber());
                couponConsumers.add(coupon);

                OrderCoupon orderCoupon = new OrderCoupon();
                orderCoupon.setOrderNo(orderNo);
                orderCoupon.setCouponAmount(e.getCouponAmount());
                orderCoupon.setCouponNo(e.getCouponNo());
                orderCoupon.setCouponNumber(e.getCouponNumber());
                orderCoupon.setCreateDateTime(LocalDateTime.now());

                orderCouponConsumers.add(orderCoupon);
            } else {
                throw BizException.builder().biz_code(400).msg("优惠券数量不足!").build();
            }
        });

        couponDao.saveAll(couponConsumers);
        orderCouponDao.saveAll(orderCouponConsumers);

        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public void rollbackOrder(String orderNo) {
        List<OrderCoupon> list = orderCouponDao.findAllByOrderNo(orderNo);
        List<Coupon> coupons = new ArrayList<>();
        if (list.isEmpty()) return;
        list.forEach(e -> {
            Coupon coupon = couponDao.findByCouponNoAndCouponStatus(e.getCouponNo(), 0).orElseThrow(DataNotFoundException::new);
            coupon.setCouponNumber(coupon.getCouponNumber() + e.getCouponNumber());
            coupons.add(coupon);
        });
        couponDao.saveAll(coupons);
        orderCouponDao.deleteByOrderNo(orderNo);
    }
}
