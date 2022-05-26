package com.yummy.delivery.service;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.OrderStatus;
import com.yummy.delivery.dto.CartResponse;
import com.yummy.delivery.dto.CreateCartRequest;
import com.yummy.delivery.dto.CreateOrderRequest;
import com.yummy.delivery.dto.CreatePaymentRequest;
import com.yummy.delivery.mapper.CartMapper;
import com.yummy.delivery.mapper.MenuMapper;
import com.yummy.delivery.mapper.OrderMapper;
import com.yummy.delivery.mapper.OrderStatusMapper;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

// 주문했을때 장바구니 비우기
// 다른 가게의 상품을 장바구니에 넣었을때 이전 장바구니 비우기
@RequiredArgsConstructor
public class CartService {
  private final CartMapper cartMapper;
  private final MenuMapper menuMapper;

  @Transactional
  public void addCart(CreateCartRequest createCartRequest) {
    // 장바구니 담기
    // 장바구니 아이템 정보
    // 조회
    // 다른 장바구니 상품들이 있냐 확인
    // 다른가게의 상품이 장바구니에 들어있는지 확인해야함
    // 다른 가게인 경우 현재 장바구니 비워주기
    // 동일 가게인 경우 장바구니 아이템 추가해주기
    List<Cart> cartList = cartMapper.findByUserId(createCartRequest.getUserId());

    boolean result = cartList.stream()
        .anyMatch(cart -> !cart.getStoreId().equals(createCartRequest.getStoreId()));
    if (result) {
      cartMapper.deleteByUserId(createCartRequest.getUserId());
    }

    cartMapper.insert(Cart.create(
        createCartRequest.getUserId(), createCartRequest.getMenuId(),
        createCartRequest.getStoreId(), createCartRequest.getCount()
    ));
  }

  public List<CartResponse> findCardItemsByUserId(Long userId) {
    List<Cart> cartList = cartMapper.findByUserId(userId);

    List<CartResponse> cartResponses = new ArrayList<>();
    for (Cart cart : cartList) {
      // TODO 고민해보세요. 문제가 있습니다.
      // IN QUERY ?
      Menu menu = menuMapper.findByMenuId(cart.getMenuId());

      CartResponse cartResponse = CartResponse.create(cart, menu);
      cartResponses.add(cartResponse);
    }

    // TODO Stream 변경
    return cartResponses;
  }

}
