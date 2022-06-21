package com.example.usersample.order.controller.dto;

import com.example.usersample.common.dto.OrderDto;
import com.example.usersample.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

public class GetOrderDto {
    @Getter
    static public class Request {
        private String orderId;

        public Request(String orderId) {
            this.orderId = orderId;
        }
    }

    @Getter
    static public class Response extends OrderDto {
        @Builder
        public Response(Order order) {
            super(order);
        }
    }
}
