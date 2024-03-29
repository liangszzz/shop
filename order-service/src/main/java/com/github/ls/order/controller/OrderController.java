package com.github.ls.order.controller;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.order.vo.OrderSubmitVO;
import com.github.ls.order.service.ShopOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Valid
@RefreshScope
@Slf4j
@RestController
@RequestMapping(value = "api/v1/order", consumes = {"application/json"})
public class OrderController {

    private final ShopOrderService shopOrderService;

    public OrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }


    @PostMapping("submit")
    public ResponseData submit(@RequestBody OrderSubmitVO orderSubmitVO) {
        String orderNo = UUID.randomUUID().toString().replace("-", "");
        try {
            shopOrderService.submit(orderSubmitVO.getGoods(), orderSubmitVO.getCoupons(), orderNo);
        } catch (RuntimeException e) {
            log.info(e.getMessage());
            shopOrderService.rollbackOrder(orderNo);
            return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).build();
        }
        return ResponseData.builder().code(ResponseCode.SUCCESS).msg(orderNo).build();
    }

    @PostMapping("rollbackOrder")
    public ResponseData rollbackOrder(@RequestParam("order_no") String orderNO) {
        shopOrderService.rollbackOrder(orderNO);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }


}
