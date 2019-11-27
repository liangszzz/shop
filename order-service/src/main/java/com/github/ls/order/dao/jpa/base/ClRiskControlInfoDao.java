package com.github.ls.order.dao.jpa.base;

import com.github.ls.order.entity.base.ClRiskControlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClRiskControlInfoDao extends JpaRepository<ClRiskControlInfo, Long> {
}
