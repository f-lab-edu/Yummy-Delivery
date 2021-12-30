package com.yummy.delivery.controller;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    /* 메뉴 등록 */
    @PostMapping("/register/{storeId}")
    public void menuSet(@PathVariable("storeId") int storeId, Menu menu){
        menuService.menuSet(storeId, menu);
    }
}
