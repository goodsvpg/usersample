package com.example.usersample.order.controller;

import com.example.usersample.order.application.OrderService;
import com.example.usersample.order.controller.dto.GetOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public GetOrderDto.Response getOrders(final GetOrderDto.Request request) {
        return orderService.orders(request);
    }
}
