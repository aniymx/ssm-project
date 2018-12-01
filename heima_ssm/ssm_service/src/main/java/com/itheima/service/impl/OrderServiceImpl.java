package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.itheima.dao.OrderDao;
import com.itheima.service.OrderService;
import com.ithiema.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> findAll(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }

    @Override
    public Order findById(String orderId) {
      return   orderDao.findById(orderId);
    }
}
