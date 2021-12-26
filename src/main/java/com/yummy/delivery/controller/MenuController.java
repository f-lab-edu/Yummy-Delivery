package com.yummy.delivery.controller;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    /* 메뉴 등록 */
    @PostMapping("menu/register/{store_id}")
    public void menuSet(@PathVariable("store_id") int store_id, Menu menu){
        menuService.menuSet(store_id, menu);
    }
}
