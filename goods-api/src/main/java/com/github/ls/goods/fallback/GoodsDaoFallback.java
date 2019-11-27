package com.github.ls.goods.fallback;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.goods.feign.GoodsDao;
import com.github.ls.goods.vo.ConsumerGoods;
import org.springframework.stereotype.Component;

@Component
public class GoodsDaoFallback implements GoodsDao {

    @Override
    public ResponseData consumer(ConsumerGoods consumerGoods) {
        return ResponseData.builder().code(ResponseCode.SERVER_EXCEPTION).build();
    }
}
