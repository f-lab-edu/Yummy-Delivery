package com.yummy.delivery.controller;

import com.yummy.delivery.dto.CartDTO;
import com.yummy.delivery.dto.MenuDTO;
import com.yummy.delivery.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    /* 장바구니 조회 */
    @GetMapping("/{userId}")
    public List<CartDTO> showCartList(@PathVariable("userId") Long userId){
        return cartService.findCartList(userId);
    }

    /* 장바구니 삭제 */

}
