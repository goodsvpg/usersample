package com.example.usersample.order.application;

import com.example.usersample.common.domain.ErrorCode;
import com.example.usersample.order.controller.dto.GetOrderDto;
import com.example.usersample.order.dao.OrderRepository;
import com.example.usersample.order.domain.Order;
import com.example.usersample.order.exception.CannotFoundOrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public GetOrderDto.Response orders(GetOrderDto.Request request) {
        Order order = orderRepository.findOrderByOrderId(request.getOrderId()).orElseThrow(
                () -> new CannotFoundOrderException(ErrorCode.CANNOT_FIND_ORDER)
        );
        return GetOrderDto.Response.builder().order(order).build();
    }
}
