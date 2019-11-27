package com.github.ls.coupon.dao;

import com.github.ls.coupon.entity.OrderCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderCouponDao extends JpaRepository<OrderCoupon,Long> {
    void deleteByCouponNo(String couponNo);

    List<OrderCoupon> findAllByOrderNo(String orderNo);

    void deleteByOrderNo(String orderNo);
}
