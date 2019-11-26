package com.github.ls.coupon.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@Validated
@Slf4j
@RefreshScope
@RestController
public class Controller {

    @PostMapping(value = "/use")
    public ResponseData use(@NotBlank @RequestParam String order_no, @NotBlank @RequestParam String coupon_no) {
        log.info("#used coupon order_no:" + order_no + " coupon_no:" + coupon_no);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }
}
