package com.github.ls.order.dao;

import com.github.ls.common.order.ClCarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClCarInfoDao extends JpaRepository<ClCarInfo, Long> {
}
