package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.OrderStatus;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderStatusMapper {

    OrderStatus findById(Integer id);

    OrderStatus findByOrderId(Integer orderId);

    OrderStatus insert(OrderStatus orderStatus);

    void update(OrderStatus orderStatus);

}