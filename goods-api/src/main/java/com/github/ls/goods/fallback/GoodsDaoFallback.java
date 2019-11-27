package com.github.ls.goods.fallback;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.feign.GoodsDao;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Component
public class GoodsDaoFallback implements GoodsDao {

    @Override
    public ResponseData consumer(@NotNull List<Goods> coupons, @NotBlank String orderNo) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }
}
