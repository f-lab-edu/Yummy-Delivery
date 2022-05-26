package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Order;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    Cart findById(Integer id);

    List<Cart> findByUserId(Long userId);
    
    Cart insert(Cart cart);

    Cart update(Cart cart);

    void deleteByUserId(Long userId);
}