package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.mq.OrderRollBackInput;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.coupon.feign.CouponDao;
import com.github.ls.coupon.vo.ConsumerCoupon;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.feign.GoodsDao;
import com.github.ls.goods.vo.ConsumerGoods;
import com.github.ls.order.dao.shop.OrderDao;
import com.github.ls.order.entity.shop.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(rollbackOn = RuntimeException.class)
@Slf4j
@Service
public class ShopOrderService {

    private final OrderDao orderDao;
    private final CouponDao couponDao;
    private final GoodsDao goodsDao;

    private final RocketMQTemplate rocketMQTemplate;

    public ShopOrderService(OrderDao orderDao, CouponDao couponDao, GoodsDao goodsDao, RocketMQTemplate rocketMQTemplate) {
        this.orderDao = orderDao;
        this.couponDao = couponDao;
        this.goodsDao = goodsDao;
        this.rocketMQTemplate = rocketMQTemplate;
    }


    public void submit(List<Goods> goods, List<UserCoupon> coupons, String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUsername("user");
        order.setCreateDateTime(LocalDateTime.now());

        ConsumerCoupon consumerCoupon = new ConsumerCoupon();
        consumerCoupon.setOrderNo(orderNo);
        consumerCoupon.setCoupons(coupons);

        ResponseData data1 = couponDao.consumer(consumerCoupon);
        if (ResponseCode.SUCCESS != data1.getCode()) throw BizException.builder().biz_code(500).msg("优惠券消费失败!").build();

        ConsumerGoods consumerGoods = new ConsumerGoods();
        consumerGoods.setOrderNo(orderNo);
        consumerGoods.setGoods(goods);

        ResponseData data2 = goodsDao.consumer(consumerGoods);
        if (ResponseCode.SUCCESS != data2.getCode()) throw BizException.builder().biz_code(500).msg("商品消费失败!").build();

        orderDao.save(order);
    }

    public void rollbackOrder(String orderNo) {
        try {
            rocketMQTemplate.send(OrderRollBackInput.DESTINATION, MessageBuilder.withPayload(orderNo).build());
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
            couponDao.rollback(orderNo);
            goodsDao.rollback(orderNo);
        }

    }
}
