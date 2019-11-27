package com.github.ls.order.dao.jpa.base;

import com.github.ls.order.entity.base.ClCarInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClCarInfoDao extends JpaRepository<ClCarInfo, Long> {
}
