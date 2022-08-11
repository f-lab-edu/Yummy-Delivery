package com.yummy.delivery.store.controller;

import com.yummy.delivery.store.dto.CreateStoreRequest;
import com.yummy.delivery.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/stores")
@RestController
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/register")
    public void create(@RequestBody CreateStoreRequest createStoreRequest) {
        storeService.create(createStoreRequest);
    }
}
