package com.example.usersample.user.application.dto;

import com.example.usersample.common.dto.OrderDto;
import com.example.usersample.user.controller.dto.UserDto;
import com.example.usersample.order.domain.Order;
import com.example.usersample.user.domain.User;
import lombok.Builder;

public class UserIncludeOrderDto extends UserDto {
    private OrderDto order;

    @Builder
    public UserIncludeOrderDto(User user, Order order) {
        super(user);
        this.order = OrderDto.builder().order(order).build();
    }
}
