package com.github.ls.coupon.mq;

import com.github.ls.common.mq.OrderRollBackInput;
import com.github.ls.coupon.service.UserCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(OrderRollBackInput.class)
public class OrderRollBackService {

    private final UserCouponService userCouponService;

    public OrderRollBackService(UserCouponService userCouponService) {
        this.userCouponService = userCouponService;
    }


    @StreamListener(value = OrderRollBackInput.ORDER_INPUT)
    public void rollBackOrder(String orderNo) {
        log.info("rollback:" + orderNo);
        userCouponService.rollbackOrder(orderNo);
    }
}
