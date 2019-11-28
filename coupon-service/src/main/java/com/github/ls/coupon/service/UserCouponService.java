package com.github.ls.coupon.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.entity.ResponseResult;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.coupon.dao.CouponDao;
import com.github.ls.coupon.dao.OrderCouponDao;
import com.github.ls.coupon.dao.UserCouponDao;
import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.entity.OrderCoupon;
import com.github.ls.coupon.entity.UserCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CouponDao couponDao;

    private final OrderCouponDao orderCouponDao;

    public UserCouponService(UserCouponDao userCouponDao, OrderCouponDao orderCouponDao, CouponDao couponDao) {
        this.userCouponDao = userCouponDao;
        this.orderCouponDao = orderCouponDao;
        this.couponDao = couponDao;
    }

    public ResponseData add(UserCoupon userCoupon) {
        Coupon coupon = couponDao.findByCouponNoAndCouponStatus(userCoupon.getCouponNo(), 0)
                .orElseThrow(DataNotFoundException::new);

        userCouponDao.findByCouponNoAndCouponStatusAndUsername(userCoupon.getCouponNo(),
                0, userCoupon.getUsername()).ifPresent(e -> {
            throw new BizException(400, "优惠券限每人一张");
        });

        userCoupon.setCouponAmount(coupon.getCouponAmount());
        userCoupon.setCreateDateTime(LocalDateTime.now());
        userCoupon.setCouponStatus(0);
        userCouponDao.save(userCoupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData del(UserCoupon userCoupon) {
        UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(userCoupon.getCouponNo(),
                0, userCoupon.getUsername()).orElseThrow(DataNotFoundException::new);
        coupon.setCouponStatus(1);
        userCouponDao.save(coupon);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData getAllByUsername(String username) {
        List<UserCoupon> userCoupons = userCouponDao.findAllByUsername(username);
        ResponseResult result = new ResponseResult();
        result.put("coupons", userCoupons);
        return ResponseData.builder().code(ResponseCode.SUCCESS).result(result).build();
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
                orderCoupon.setUsername(coupon.getUsername());
                orderCoupon.setCouponAmount(coupon.getCouponAmount());
                orderCoupon.setCouponNo(coupon.getCouponNo());
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
            UserCoupon coupon = userCouponDao.findByCouponNoAndCouponStatusAndUsername(e.getCouponNo(), 0, e.getUsername()).orElseThrow(DataNotFoundException::new);
            coupon.setCouponNumber(coupon.getCouponNumber() + e.getCouponNumber());
            coupons.add(coupon);
        });
        orderCouponDao.deleteByOrderNo(orderNo);
        userCouponDao.saveAll(coupons);
    }


}
