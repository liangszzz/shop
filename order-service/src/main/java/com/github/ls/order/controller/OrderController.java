package com.github.ls.order.controller;

import com.github.ls.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Valid
@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/shop/order", consumes = {"application/json"})
public class OrderController {


    public ResponseData submit() {

        return null;
    }


}
