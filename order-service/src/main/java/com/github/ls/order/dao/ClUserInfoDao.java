package com.github.ls.order.dao;

import com.github.ls.common.order.ClUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClUserInfoDao extends JpaRepository<ClUserInfo, Long> {
}
