package com.yummy.delivery.controller;

import com.yummy.delivery.dto.CartRequestDTO;
import com.yummy.delivery.dto.CartResponseDTO;
import com.yummy.delivery.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{userId}/carts")
    public List<CartResponseDTO> findCartList(@PathVariable("userId") Long userId) {
        return cartService.findCartItemsByUserId(userId);
    }

    @PostMapping("/carts")
    public void addCart(@RequestBody @Valid CartRequestDTO cartRequestDTO) {
        cartService.addCart(cartRequestDTO);
    }

    @DeleteMapping("/{userId}/carts/{id}")
    public void deleteCartList(@PathVariable("id") Long id) {
        cartService.deleteAllCartList(id);
    }


}
