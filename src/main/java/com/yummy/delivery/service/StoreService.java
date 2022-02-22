package com.yummy.delivery.service;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Store;
import com.yummy.delivery.dto.MenuFindResponseDTO;
import com.yummy.delivery.dto.MenuResponseDTO;
import com.yummy.delivery.dto.StoreDTO;
import com.yummy.delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreMapper storeMapper;

    public void insertStore(StoreDTO storeDTO) {

        Store storeBuilder = Store.builder()
                .id(storeDTO.getId())
                .sellerId(storeDTO.getSellerId())
                .name(storeDTO.getName())
                .phone(storeDTO.getPhone())
                .address(storeDTO.getAddress())
                .category(storeDTO.getCategory())
                .build();

        storeMapper.insertStore(storeBuilder);

    }

    public MenuResponseDTO findStoreMenu(long storeId) {
        List<Menu> menus = storeMapper.findStoreMenu(storeId);
        List<MenuFindResponseDTO> menuResponse = new ArrayList<>();

        for(Menu menu : menus) {
            menuResponse.add(MenuFindResponseDTO.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .photo(menu.getPhoto())
                    .description(menu.getDescription())
                    .createdAt(menu.getCreatedAt())
                    .updatedAt(menu.getUpdatedAt())
                    .build());
        }

        return MenuResponseDTO.builder()
                .menuFindResponse(menuResponse)
                .build();
    }

}
