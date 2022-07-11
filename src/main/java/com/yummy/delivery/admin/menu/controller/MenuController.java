package com.yummy.delivery.admin.menu.controller;

import com.yummy.delivery.admin.menu.MenuService;
import com.yummy.delivery.admin.menu.dto.CreateMenuRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("admin.MenuController")
public class MenuController {
  private final MenuService menuService;

  @PostMapping("/menus")
  public void create(@RequestBody CreateMenuRequest createMenuRequest) {
    menuService.createMenu(createMenuRequest);
  }

}
