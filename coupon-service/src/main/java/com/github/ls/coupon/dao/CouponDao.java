package com.github.ls.coupon.dao;

import com.github.ls.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponDao extends JpaRepository<Coupon,Long> {

    Optional<Coupon> findByCouponNoAndCouponStatus(String couponNo, Integer couponStatus);

    void deleteByCouponNo(String couponNo);
}
