package com.github.ls.common.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderRollBackOutput {

    String ORDER_OUTPUT = "order-rollback-output";

    @Output(ORDER_OUTPUT)
    MessageChannel output();
}
