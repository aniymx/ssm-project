package com.itheima.service;


import com.ithiema.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void saveProduct(Product product);
}
