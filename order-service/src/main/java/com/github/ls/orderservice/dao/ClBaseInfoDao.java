package com.github.ls.orderservice.dao;

import com.github.ls.common.order.ClBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClBaseInfoDao extends JpaRepository<ClBaseInfo, Long> {
}
