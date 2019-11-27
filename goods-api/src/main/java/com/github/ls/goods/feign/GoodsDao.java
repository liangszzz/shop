package com.github.ls.goods.feign;

import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@FeignClient(value = "spring-cloud-goods")
public interface GoodsDao {

    @PostMapping("api/v1/goods/consumer")
    ResponseData consumer(@NotNull @RequestParam("goods") List<Goods> coupons,
                               @NotBlank @RequestParam("order_no") String orderNo);

}
