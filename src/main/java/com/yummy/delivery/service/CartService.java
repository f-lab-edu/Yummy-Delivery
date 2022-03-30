package com.yummy.delivery.service;

import com.yummy.delivery.dto.CartDTO;
import com.yummy.delivery.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartMapper cartMapper;

    public List<CartDTO> findCartList(@Param("userId") Long userId){
        return cartMapper.findCartList(userId);
    }

    public void deleteAllCartList(@Param("id") Long id){
        cartMapper.deleteAllCartList(id);
    }

    public void deleteSelectCartList(@Param("userId") Long userId, @Param("menuName") String menuName){
        cartMapper.deleteSelectCartList(userId, menuName);
    }



}
