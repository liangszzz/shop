package com.github.ls.order.dao.jpa.base;

import com.github.ls.order.entity.base.ClBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ClBaseInfoDao extends JpaRepository<ClBaseInfo, Long> {

    Optional<ClBaseInfo> findByLoadOrderNo(String loadOrderNo);
}
