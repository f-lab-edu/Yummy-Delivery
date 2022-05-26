package com.yummy.delivery.service;

import com.yummy.delivery.domain.Cart;
import com.yummy.delivery.domain.Order;
import com.yummy.delivery.domain.OrderStatus;

import org.junit.Test;
import org.spockframework.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartDomainTest {

  @Test
  public void 장바구니_담기() {
    // given
    Long userId = 1L;
    Long menuId = 1L;
    Long storeId = 1L;
    Integer count = 2;

    // when
    Cart result = Cart.create(userId, menuId, storeId, count);

    // then
    assertEquals(result.getUserId(), userId);
    assertEquals(result.getMenuId(), menuId);
    assertEquals(result.getStoreId(), storeId);
    assertEquals(result.getCount(), count);
  }

  @Test
  public void test() {
    List<Cart> cartList = new ArrayList<>();
    Cart cart1 = new Cart();
    cartList
        .add(cart1);

    cart1.setStoreId(1L);
    Cart cart2 = new Cart();
    cartList
        .add(cart2);
    cart2.setStoreId(1L);

    Long requestStoreId = 1L;

    System.out.println(cartList.stream()
        .anyMatch(cart -> !cart.getStoreId().equals(requestStoreId)));

    // 가게 바뀐것


  }
}