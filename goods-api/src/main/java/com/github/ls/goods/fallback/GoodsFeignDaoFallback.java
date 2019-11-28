package com.github.ls.goods.fallback;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.feign.GoodsFeignDao;
import com.github.ls.goods.vo.ConsumerGoods;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class GoodsFeignDaoFallback implements GoodsFeignDao {

    @Override
    public ResponseData consumer(ConsumerGoods consumerGoods) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }

    @Override
    public ResponseData rollback(@NotBlank String orderNo) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }
}
