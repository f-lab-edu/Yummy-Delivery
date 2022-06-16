package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    Cart findById(Integer id);

    List<Cart> findByUserId(@Param("userId") Long userId);

    Cart insertCart(Cart cart);

    Cart updateCart(Cart cart);

    void deleteByUserId(@Param("userId") Long userId);

}
