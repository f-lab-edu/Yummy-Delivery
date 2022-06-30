package com.yummy.delivery.store.controller;

import com.yummy.delivery.store.StoreService;
import com.yummy.delivery.store.dto.FindStoreResponse;
import com.yummy.delivery.store.dto.SetUpStoreRequest;
import com.yummy.delivery.user.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class StoreController {
  private final StoreService storeService;

  @PostMapping("/stores")
  public void setUp(@RequestBody SetUpStoreRequest setUpStoreRequest) {
    // ?? sellerId
    Long sellerId = 1L;
    storeService.setUpStore(sellerId, setUpStoreRequest);
  }


  @GetMapping("/stores")
  public List<FindStoreResponse> findAllByQuery(@RequestParam String address, @RequestParam String category) {
    return storeService.findAllByCategoryAndAddress(category, address);
  }
}
