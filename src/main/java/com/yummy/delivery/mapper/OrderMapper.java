package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.Seller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    Order findById(Integer id);

    Order findByUserId(Integer userId);
    
    Integer insert(Order order);

    void update(Order order);

}