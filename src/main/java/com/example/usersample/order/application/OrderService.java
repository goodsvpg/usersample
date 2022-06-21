package com.example.usersample.order.application;

import com.example.usersample.common.dto.OrderDto;
import com.example.usersample.order.controller.dto.GetOrderDto;

public interface OrderService {
    GetOrderDto.Response orders(GetOrderDto.Request request);
}
