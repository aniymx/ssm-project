package com.itheima.web.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/showProductList")
    public ModelAndView showProductList(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();

        //测试数据库是否联通
        for (Product product : productList) {
            System.out.println(product);

        }


        mv.addObject("productlist",productList);
        //跳转的路径
        mv.setViewName("");

        return mv;
    }


}
