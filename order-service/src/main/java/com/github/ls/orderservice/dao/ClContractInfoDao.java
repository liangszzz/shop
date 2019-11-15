package com.github.ls.orderservice.dao;

import com.github.ls.common.order.ClContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClContractInfoDao extends JpaRepository<ClContactInfo, Long> {
}
