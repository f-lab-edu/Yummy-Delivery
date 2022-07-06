package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.dto.CartResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MenuMapper {

    void insertMenu(Menu menu);

    List<CartResponseDTO> findByMenuId(List<Cart> cartList);
}
