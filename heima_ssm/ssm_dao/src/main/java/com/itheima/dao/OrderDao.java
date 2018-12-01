package com.itheima.dao;

import com.ithiema.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Select("select * from orders")
    @Results({//property对应pojo中的名称,column是对应数据库字段的名称
            @Result(id = true,property ="id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.itheima.dao.ProductDao.findById"))
    })
    List<Order> findAll();

    @Select("select * from orders where id =#{id}")
    @Results({//property对应pojo中的名称,column是对应数据库字段的名称
            @Result(id = true,property ="id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(column = "id",property = "travellers",many =@Many(select = "com.itheima.dao.TravellerDao.findById"))
    })
    Order findById(String id);


}
