package com.github.ls.order.controller;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.order.entity.SubmitOrderVO;
import com.github.ls.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/order")
public class Controller {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/submitOrder")
    public ResponseData submitOrder(@RequestBody SubmitOrderVO vo) {
        return orderService.submitOrder(null);
    }
}
