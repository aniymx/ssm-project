package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.service.ProductService;
import com.ithiema.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired(required = true)
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
