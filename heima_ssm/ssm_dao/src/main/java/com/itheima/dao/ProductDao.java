package com.itheima.dao;

import com.itheima.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    List<Product> findAll();
}
