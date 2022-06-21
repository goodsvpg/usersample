package com.example.usersample.order.dao;

import com.example.usersample.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findOrderByOrderId(String orderId);
}
