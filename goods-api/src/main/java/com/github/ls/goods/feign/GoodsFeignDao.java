package com.github.ls.goods.feign;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.fallback.GoodsFeignDaoFallback;
import com.github.ls.goods.vo.ConsumerGoods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

@Primary
@FeignClient(value = "spring-cloud-goods", fallback = GoodsFeignDaoFallback.class)
public interface GoodsFeignDao {

    @PostMapping("api/v1/goods/consumer")
    ResponseData consumer(@RequestBody ConsumerGoods consumerGoods);

    @PostMapping("api/v1/goods/rollback")
    ResponseData rollback(@NotBlank @RequestParam("order_no") String orderNo);

}
