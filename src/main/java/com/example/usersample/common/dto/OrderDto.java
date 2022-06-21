package com.example.usersample.common.dto;

import com.example.usersample.order.domain.Order;
import lombok.Builder;

import java.time.LocalDateTime;

public class OrderDto {
    private String orderId;

    private String productName;

    private LocalDateTime payDate;

    @Builder
    public OrderDto(Order order) {
        this.orderId = order.getOrderId();
        this.productName = order.getProductName();
        this.payDate = order.getPayDate();
    }
}
