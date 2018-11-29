package com.itheima.web.controller;

import com.itheima.service.ProductService;
import com.ithiema.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
@RequestMapping("save.do")
    public String saveProduct(Product product){

        productService.saveProduct(product);

        return "redirect:findAll.do";
    }




    @RequestMapping("/findAll.do")
    public ModelAndView showProductList(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
/*

        //测试数据库是否联通
        for (Product product : productList) {
            System.out.println(product);

        }

*/

        mv.addObject("productList",productList);
        //跳转的路径
        mv.setViewName("product-list");

        return mv;
    }


}
