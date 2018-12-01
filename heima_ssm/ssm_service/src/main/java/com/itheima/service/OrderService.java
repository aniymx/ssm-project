package com.itheima.service;

import com.ithiema.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll(Integer page,Integer size);

    Order findById(String orderId);
}
