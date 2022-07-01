package com.yummy.delivery.controller;

import com.yummy.delivery.annotation.LoginUser;
import com.yummy.delivery.dto.MenuResponseDTO;
import com.yummy.delivery.dto.StoreDTO;
import com.yummy.delivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yummy.delivery.httpStatus.httpComponent.RESPONSE_ENTITY_OK;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @LoginUser
    @PostMapping("/register")
    public ResponseEntity<Void> insertStore(@RequestBody StoreDTO storeDTO) {
        storeService.insertStore(storeDTO);
        return RESPONSE_ENTITY_OK;
    }

    @LoginUser
    @GetMapping("/{storesId}/menus")
    public ResponseEntity<MenuResponseDTO> findStoreMenu(@PathVariable("storesId") long storeId) {
        return ResponseEntity.ok(storeService.findStoreMenu(storeId));
    }

}
