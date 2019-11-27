package com.github.ls.goods.service;

import com.github.ls.common.entity.ResponseCode;
import com.github.ls.common.entity.ResponseData;
import com.github.ls.common.exceptions.BizException;
import com.github.ls.common.exceptions.DataNotFoundException;
import com.github.ls.goods.dao.GoodsDao;
import com.github.ls.goods.dao.OrderGoodsDao;
import com.github.ls.goods.entity.Goods;
import com.github.ls.goods.entity.OrderGoods;
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

    public ResponseData add(Goods goods) {
        goods.setCreateDateTime(LocalDateTime.now());
        goods.setGoodsStatus(0);
        goodsDao.save(goods);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData addNumber(String goodsNo, Long number) {
        Goods goods = goodsDao.findByGoodsNoAndGoodsStatus(goodsNo, 0).orElseThrow(DataNotFoundException::new);
        if (goods.getGoodsNumber() + number >= 0) {
            goods.setGoodsNumber(goods.getGoodsNumber() + number);
            goodsDao.save(goods);
            return ResponseData.builder().code(ResponseCode.SUCCESS).build();
        } else {
            return ResponseData.builder().code(ResponseCode.BIZ_EXCEPTION).msg("库存不能小于0").build();
        }
    }

    public ResponseData del(String goodsNo) {
        Goods goods = goodsDao.findByGoodsNoAndGoodsStatus(goodsNo, 0).orElseThrow(DataNotFoundException::new);
        goods.setGoodsStatus(1);
        goodsDao.save(goods);
        return ResponseData.builder().code(ResponseCode.SUCCESS).build();
    }

    public ResponseData consumer(List<Goods> goods, String orderNo) {
        List<Goods> goodsConsumers = new ArrayList<>(goods.size());
        List<OrderGoods> orderGoodsConsumers = new ArrayList<>(goods.size());

        goods.forEach(e -> {
            Goods g1 = goodsDao.findByGoodsNoAndGoodsStatus(e.getGoodsNo(), 0).orElseThrow(DataNotFoundException::new);
            if (g1.getGoodsNumber() >= e.getGoodsNumber()) {
                g1.setGoodsNumber(g1.getGoodsNumber() - e.getGoodsNumber());
                goodsConsumers.add(g1);

                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setOrderNo(orderNo);
                orderGoods.setGoodsNo(e.getGoodsNo());
                orderGoods.setGoodsNumber(e.getGoodsNumber());
                orderGoods.setGoodsPrice(e.getGoodsPrice());

                orderGoodsConsumers.add(orderGoods);
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
            Optional<Goods> g1 = goodsDao.findByGoodsNoAndGoodsStatus(e.getGoodsNo(), 0);
            g1.ifPresent(value -> goods.add(value.addGoodsNumber(e.getGoodsNumber())));
        });

        orderGoodsDao.deleteAll(list);
        goodsDao.saveAll(goods);
    }
}
