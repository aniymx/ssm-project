package com.itheima.dao;

import com.ithiema.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {


    @Select("select * from product")
    List<Product> findAll();
}
