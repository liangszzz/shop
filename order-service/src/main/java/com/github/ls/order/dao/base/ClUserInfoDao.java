package com.github.ls.order.dao.base;

import com.github.ls.order.entity.base.ClUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ClUserInfoDao extends JpaRepository<ClUserInfo, Long> {
}
