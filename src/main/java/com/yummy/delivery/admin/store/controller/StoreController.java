package com.yummy.delivery.admin.store.controller;

import com.yummy.delivery.admin.store.StoreService;
import com.yummy.delivery.admin.store.dto.SetUpStoreRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController("admin.StoreController")
public class StoreController {
  private final StoreService storeService;

  @PostMapping("/stores")
  public void setUp(@RequestBody SetUpStoreRequest setUpStoreRequest) {
    // ?? sellerId
    Long sellerId = 1L;
    storeService.setUpStore(sellerId, setUpStoreRequest);
  }

}
