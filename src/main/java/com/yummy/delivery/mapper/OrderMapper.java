package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO Order (id, user_id, store_id, pay_type, total_price, address, created_at) " +
            "VALUES(#{id}, #{userId}, #{storeId}, #{payType}, #{totalPrice}, #{address}, #{createdAt})")
    void insertOrder(Order order);


}
