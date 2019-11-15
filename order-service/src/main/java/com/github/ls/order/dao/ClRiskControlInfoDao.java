package com.github.ls.order.dao;

import com.github.ls.common.order.ClRiskControlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClRiskControlInfoDao extends JpaRepository<ClRiskControlInfo, Long> {
}
