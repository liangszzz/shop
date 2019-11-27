package com.github.ls.order.dao.shop;

import com.github.ls.order.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
