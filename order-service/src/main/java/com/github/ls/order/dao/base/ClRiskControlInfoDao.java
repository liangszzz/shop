package com.github.ls.order.dao.base;

import com.github.ls.order.entity.base.ClRiskControlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ClRiskControlInfoDao extends JpaRepository<ClRiskControlInfo, Long> {
}
