package com.github.ls.order.dao;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.order.dao.fall.OrderMqDaoFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Primary
@FeignClient(value = "spring-cloud-stream", fallback = OrderMqDaoFallBack.class)
public interface OrderMqDao {

    @PostMapping("api/mq/order/attachmentUploadMq/{order_no}")
    ResponseData attachmentUploadMq(@PathVariable String order_no);

    @PostMapping("api/mq/order/contractCreateMq/{order_no}")
    ResponseData contractCreateMq(@PathVariable String order_no);

}
