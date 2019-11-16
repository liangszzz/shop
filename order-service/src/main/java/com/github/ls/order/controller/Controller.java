package com.github.ls.order.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.order.entity.AddAttachmentVO;
import com.github.ls.order.entity.ApproveVO;
import com.github.ls.order.entity.SubmitOrderVO;
import com.github.ls.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/order",consumes = {"application/json"})
public class Controller {

    private final OrderService orderService;

    @Autowired
    public Controller(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/submitOrder")
    public ResponseData submitOrder(@Validated @RequestBody SubmitOrderVO vo) {
        return orderService.submitOrder(vo);
    }

    @PostMapping(value = "/addAttachment")
    public ResponseData addAttachment(@Validated @RequestBody AddAttachmentVO vo){
        return orderService.addAttachment(vo);
    }

    @PostMapping(value = "/approveOrder")
    public ResponseData approveOrder(@Validated @RequestBody ApproveVO vo) {
        return orderService.approveOrder(vo);
    }
}
