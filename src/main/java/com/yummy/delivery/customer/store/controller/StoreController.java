package com.yummy.delivery.customer.store.controller;

import com.yummy.delivery.admin.store.dto.FindStoreResponse;
import com.yummy.delivery.customer.store.StoreService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("customer.StoreController")
public class StoreController {
  private final StoreService storeService;

  @GetMapping("/stores")
  public List<FindStoreResponse> findAllByQuery(@RequestParam String address, @RequestParam String category) {
    return storeService.findAllByCategoryAndAddress(category, address);
  }
}
