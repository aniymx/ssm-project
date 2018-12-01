package com.itheima.web.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;

import com.ithiema.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//订单
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

  /*  @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll();
        modelAndView.addObject("ordersList", orderList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    //使用分页对查询所有的数据
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(orderList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String orderId) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findById(orderId);
        modelAndView.addObject("orders",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
