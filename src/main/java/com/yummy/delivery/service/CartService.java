package com.yummy.delivery.service;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Store;
import com.yummy.delivery.dto.CartRequestDTO;
import com.yummy.delivery.dto.CartResponseDTO;
import com.yummy.delivery.mapper.CartMapper;
import com.yummy.delivery.mapper.MenuMapper;
import com.yummy.delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;
    private final MenuMapper menuMapper;

    @Transactional
    public void addCart(CartRequestDTO cartRequestDTO) {

        List<Cart> cartList = cartMapper.findByUserId(cartRequestDTO.getUserId());

        boolean result = cartList.stream()
                .anyMatch(cart -> !cart.getStoreId().equals(cartRequestDTO.getStoreId()));

        if(result) {
            cartMapper.deleteByUserId(cartRequestDTO.getUserId());
        }

        cartMapper.insertCart(Cart.create(
                cartRequestDTO.getUserId(), cartRequestDTO.getStoreId(),
                cartRequestDTO.getMenuId(), cartRequestDTO.getCount()
        ));
    }

    public List<CartResponseDTO> findCartItemsByUserId(Long userId) {

        List<Cart> cartList = cartMapper.findByUserId(userId);

        List<CartResponseDTO> cartResponseDTOS = new ArrayList<>();

        for(Cart cart : cartList) {

            Menu menu = menuMapper.findByMenuId(cart.getMenuId());

            CartResponseDTO cartResponseDTO = CartResponseDTO.create(cart, menu);
            cartResponseDTOS.add(cartResponseDTO);

        }

        return cartResponseDTOS;
    }



}
