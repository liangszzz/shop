package com.github.ls.goods.dao;

import com.github.ls.goods.entity.base.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsDao extends JpaRepository<Goods, Long> {
    Optional<Goods> findByGoodsNoAndGoodsStatus(String goodsNo,Integer goodStatus);

    void deleteByGoodsNo(String goodsId);
}
