package com.github.ls.goods.dao;

import com.github.ls.goods.entity.base.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderGoodsDao extends JpaRepository<OrderGoods, Long> {

    List<OrderGoods> findAllByOrderNo(String order_no);

    void deleteByGoodsId(String goodsId);
}
