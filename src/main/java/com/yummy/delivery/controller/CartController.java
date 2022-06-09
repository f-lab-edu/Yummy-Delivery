package com.yummy.delivery.controller;

import com.yummy.delivery.dto.CartRequestDTO;
import com.yummy.delivery.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class CartController {

    private final CartService cartService;

    @PostMapping("/carts")
    public void addCart(@RequestBody @Valid CartRequestDTO cartRequestDTO) {
        cartService.addCart(cartRequestDTO);
    }


}
