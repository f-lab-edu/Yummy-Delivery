package com.yummy.delivery.controller;

import com.yummy.delivery.dto.MenuDTO;
import com.yummy.delivery.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    /* 메뉴 등록 */
    @PostMapping("/register/{storeId}")
    public void menuSet(@PathVariable("storeId") int storeId, @RequestBody MenuDTO menuDTO){
        menuService.insertMenu(storeId, menuDTO);
    }
}
