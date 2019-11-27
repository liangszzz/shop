package com.github.ls.common.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface OrderRollBackInput {

    String DESTINATION = "order-rollback";

    String ORDER_INPUT = "order-rollback-input";

    @Input(ORDER_INPUT)
    SubscribableChannel input();
}
