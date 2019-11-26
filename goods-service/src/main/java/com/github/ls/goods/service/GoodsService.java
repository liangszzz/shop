package com.github.ls.goods.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.goods.dao.GoodsDao;
import com.github.ls.goods.dao.OrderGoodsDao;
import com.github.ls.goods.entity.base.Goods;
import com.github.ls.goods.entity.base.OrderGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional(rollbackOn = RuntimeException.class)
public class GoodsService {

    private final GoodsDao goodsDao;

    private final OrderGoodsDao orderGoodsDao;

    public GoodsService(GoodsDao goodsDao, OrderGoodsDao orderGoodsDao) {
        this.goodsDao = goodsDao;
        this.orderGoodsDao = orderGoodsDao;
    }

    public ResponseData addGoods(Goods goods) {
        goods.setCreateDateTime(LocalDateTime.now());
        goodsDao.save(goods);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData addGoodsNumber(String goodsId, Long number) {
        Goods goods = goodsDao.findByGoodsId(goodsId).orElseThrow(DataNotFoundException::new);
        goods.setGoodsNumber(goods.getGoodsNumber() + number);
        goodsDao.save(goods);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData delGoods(String goodsId) {
        goodsDao.deleteByGoodsId(goodsId);
        orderGoodsDao.deleteByGoodsId(goodsId);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData consumerGoods(List<Goods> goods, String orderNo) {
        List<Goods> goodsConsumers = new ArrayList<>(goods.size());
        List<OrderGoods> orderGoodsConsumers = new ArrayList<>(goods.size());

        goods.forEach(e -> {
            Goods g1 = goodsDao.findByGoodsId(e.getGoodsId()).orElseThrow(DataNotFoundException::new);
            if (g1.getGoodsNumber() >= e.getGoodsNumber()) {
                g1.setGoodsNumber(g1.getGoodsNumber() - e.getGoodsNumber());
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setOrderNo(orderNo);
                orderGoods.setGoodsId(e.getGoodsId());
                orderGoods.setGoodsNumber(e.getGoodsNumber());
                orderGoodsConsumers.add(orderGoods);
                goodsConsumers.add(g1);
            } else {
                throw new BizException(400, e.getGoodsName() + " 库存不足!");
            }
        });
        goodsDao.saveAll(goodsConsumers);
        orderGoodsDao.saveAll(orderGoodsConsumers);

        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public void rollBackOrder(String order_no) {
        List<OrderGoods> list = orderGoodsDao.findAllByOrderNo(order_no);
        if (list.isEmpty()) return;
        List<Goods> goods = new ArrayList<>(list.size());

        list.forEach(e -> {
            Optional<Goods> g1 = goodsDao.findByGoodsId(e.getGoodsId());
            if (g1.isPresent()) {
                goods.add(g1.get().addGoodsNumber(e.getGoodsNumber()));
            }
        });

        orderGoodsDao.deleteAll(list);
        goodsDao.saveAll(goods);
    }
}
