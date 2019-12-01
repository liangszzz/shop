package com.github.ls.goods.mq;

import com.github.ls.common.mq.OrderRollBackInput;
import com.github.ls.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableBinding(OrderRollBackInput.class)
public class OrderRollBackService {


    private GoodsService goodsService;

    public OrderRollBackService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @StreamListener(value = OrderRollBackInput.ORDER_INPUT)
    public void rollBackOrder(String orderNo) {
        log.info("goods rollback " + orderNo);
        goodsService.rollBackOrder(orderNo);
    }
}
