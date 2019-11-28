package com.github.ls.coupon.dao;

import com.github.ls.coupon.entity.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserCouponDao extends JpaRepository<UserCoupon, Long> {

    Optional<UserCoupon> findByCouponNoAndCouponStatusAndUsername(String couponNo, Integer couponStatus, String username);

    List<UserCoupon> findAllByUsername(String username);

}
