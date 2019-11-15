package com.github.ls.orderservice.controller;

import com.github.ls.orderservice.entity.SubmitOrderVO;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "api/v1/order", method = RequestMethod.POST, consumes = "application/json")
public class Controller {


    @GetMapping("/submitOrder")
    public String submitOrder(SubmitOrderVO SubmitOrderVOs) {
        return "hello ";
    }
}
