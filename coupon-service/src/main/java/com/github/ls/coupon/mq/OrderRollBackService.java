package com.github.ls.coupon.mq;

import com.github.ls.common.mq.OrderRollBackInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(OrderRollBackInput.class)
public class OrderRollBackService {

    @StreamListener(value = OrderRollBackInput.ORDER_INPUT)
    public void rollBackOrder(String order_no) {
        log.info("rollback" + order_no);
    }
}
