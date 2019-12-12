package com.github.ls.order.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.mq.OrderRollBackOutput;
import com.github.ls.coupon.entity.UserCoupon;
import com.github.ls.coupon.feign.UserCouponFeignDao;
import com.github.ls.coupon.vo.ConsumerCoupon;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.feign.GoodsFeignDao;
import com.github.ls.goods.vo.ConsumerGoods;
import com.github.ls.order.dao.OrderDao;
import com.github.ls.order.entity.shop.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional(rollbackOn = RuntimeException.class)
@Slf4j
@Service
@EnableBinding(value = {OrderRollBackOutput.class})
public class ShopOrderService {

    private final OrderDao orderDao;
    private final UserCouponFeignDao userCouponFeignDao;
    private final GoodsFeignDao goodsFeignDao;

    private final OrderRollBackOutput orderRollBackOutput;

    public ShopOrderService(OrderDao orderDao, UserCouponFeignDao userCouponFeignDao, GoodsFeignDao goodsFeignDao, OrderRollBackOutput orderRollBackOutput) {
        this.orderDao = orderDao;
        this.userCouponFeignDao = userCouponFeignDao;
        this.goodsFeignDao = goodsFeignDao;
        this.orderRollBackOutput = orderRollBackOutput;
    }


    public void submit(List<Goods> goods, List<UserCoupon> coupons, String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUsername("user");
        order.setCreateDateTime(LocalDateTime.now());

        ConsumerCoupon consumerCoupon = new ConsumerCoupon();
        consumerCoupon.setOrderNo(orderNo);
        consumerCoupon.setCoupons(coupons);

        ConsumerGoods consumerGoods = new ConsumerGoods();
        consumerGoods.setOrderNo(orderNo);
        consumerGoods.setGoods(goods);

        ResponseData data2 = goodsFeignDao.consumer(consumerGoods);
        if (ResponseCode.SUCCESS != data2.getCode()) throw BizException.builder().biz_code(500).msg("商品消费失败!").build();

        ResponseData data1 = userCouponFeignDao.consumer(consumerCoupon);
        if (ResponseCode.SUCCESS != data1.getCode()) throw BizException.builder().biz_code(500).msg("优惠券消费失败!").build();

        orderDao.save(order);
    }

    public void rollbackOrder(String orderNo) {
        boolean send = orderRollBackOutput.output().send(MessageBuilder.withPayload(orderNo).setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 3).build(), 200);
        if (!send) {
            log.info("orderNo:" + orderNo + "send fail");
            userCouponFeignDao.rollback(orderNo);
            goodsFeignDao.rollback(orderNo);
        }
    }
}
