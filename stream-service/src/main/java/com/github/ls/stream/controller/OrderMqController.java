package com.github.ls.stream.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/mq/order")
public class OrderMqController {

    @PostMapping("/attachmentUploadMq/{order_no}")
    public ResponseData attachmentUploadMq(@PathVariable String order_no) {
        log.info(order_no);
        return new ResponseData(ResponseCode.SUCCESS);
    }

    @PostMapping("/contractCreateMq{order_no}")
    public ResponseData contractCreateMq(@PathVariable String order_no) {
        log.info(order_no);
        return new ResponseData(ResponseCode.SUCCESS);
    }
}
