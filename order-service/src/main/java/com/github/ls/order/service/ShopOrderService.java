package com.github.ls.order.service;

import com.github.ls.coupon.entity.Coupon;
import com.github.ls.coupon.feign.CouponDao;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.feign.GoodsDao;
import com.github.ls.order.dao.shop.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopOrderService {

    private final OrderDao orderDao;
    private final CouponDao couponDao;
    private final GoodsDao goodsDao;

    public ShopOrderService(OrderDao orderDao, CouponDao couponDao, GoodsDao goodsDao) {
        this.orderDao = orderDao;
        this.couponDao = couponDao;
        this.goodsDao = goodsDao;
    }


    public void submit(List<Goods> goods, List<Coupon> coupons) {
    }
}
