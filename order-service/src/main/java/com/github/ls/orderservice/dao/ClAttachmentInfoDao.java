package com.github.ls.orderservice.dao;

import com.github.ls.common.order.ClAttachmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClAttachmentInfoDao extends JpaRepository<ClAttachmentInfo,Long> {
}
