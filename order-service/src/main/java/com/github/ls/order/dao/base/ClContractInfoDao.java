package com.github.ls.order.dao.base;

import com.github.ls.order.entity.base.ClContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClContractInfoDao extends JpaRepository<ClContactInfo, Long> {
}
