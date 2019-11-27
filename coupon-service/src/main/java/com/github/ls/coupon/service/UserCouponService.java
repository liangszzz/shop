package com.github.ls.coupon.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.coupon.dao.CouponDao;
import com.github.ls.coupon.dao.OrderCouponDao;
import com.github.ls.coupon.dao.UserCouponDao;
import com.github.ls.coupon.entity.OrderCoupon;
import com.github.ls.coupon.entity.UserCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackOn = RuntimeException.class)
@Slf4j
@Service
public class UserCouponService {

    private final UserCouponDao userCouponDao;

    private final OrderCouponDao orderCouponDao;

    public UserCouponService(UserCouponDao userCouponDao, OrderCouponDao orderCouponDao) {
        this.userCouponDao = userCouponDao;
        this.orderCouponDao = orderCouponDao;
    }

    public ResponseData add(UserCoupon coupon) {
        coupon.setCreateDateTime(LocalDateTime.now());
        coupon.setCouponStatus(0);
        userCouponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData updateUserCoupon(UserCoupon userCoupon) {
        UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(userCoupon.getCouponNo(),
                userCoupon.getCouponStatus(), userCoupon.getUsername()).orElseThrow(DataNotFoundException::new);
        coupon.setCouponAmount(userCoupon.getCouponAmount());
        coupon.setCouponNumber(userCoupon.getCouponNumber());
        coupon.setCouponStatus(userCoupon.getCouponStatus());
        userCouponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData del(UserCoupon userCoupon) {
        UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(userCoupon.getCouponNo(),
                userCoupon.getCouponStatus(), userCoupon.getUsername()).orElseThrow(DataNotFoundException::new);
        coupon.setCouponStatus(1);
        userCouponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData consumer(List<UserCoupon> coupons, String orderNo) {

        List<UserCoupon> couponConsumers = new ArrayList<>(coupons.size());
        List<OrderCoupon> orderCouponConsumers = new ArrayList<>(coupons.size());

        coupons.forEach(e -> {
            UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(e.getCouponNo(), 0,
                    e.getUsername()).orElseThrow(DataNotFoundException::new);
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

        userCouponDao.saveAll(couponConsumers);
        orderCouponDao.saveAll(orderCouponConsumers);

        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public void rollbackOrder(String orderNo) {
        List<OrderCoupon> list = orderCouponDao.findAllByOrderNo(orderNo);
        List<UserCoupon> coupons = new ArrayList<>();
        if (list.isEmpty()) return;
        list.forEach(e -> {
            UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(e.getCouponNo(), 0,e.getUsername()).orElseThrow(DataNotFoundException::new);
            coupon.setCouponNumber(coupon.getCouponNumber() + e.getCouponNumber());
            coupons.add(coupon);
        });
        orderCouponDao.deleteByOrderNo(orderNo);
        userCouponDao.saveAll(coupons);
    }


}
