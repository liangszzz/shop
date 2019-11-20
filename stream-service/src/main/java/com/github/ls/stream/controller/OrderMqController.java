package com.github.ls.stream.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.order.mq.AddAttachmentVO;
import com.github.ls.stream.channel.UploadAttachmentChannel;
import com.github.ls.stream.service.OrderMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/mq/order")
public class OrderMqController {

    private final OrderMqService orderMqService;

    public OrderMqController(OrderMqService orderMqService) {
        this.orderMqService = orderMqService;
    }

    @PostMapping("/attachmentUploadMq")
    public ResponseData attachmentUploadMq(@RequestBody AddAttachmentVO vo) {
        return orderMqService.attachmentUploadMq(vo);
    }

    @PostMapping("/contractCreateMq{order_no}")
    public ResponseData contractCreateMq(@PathVariable String order_no) {
        log.info(order_no);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }
}
