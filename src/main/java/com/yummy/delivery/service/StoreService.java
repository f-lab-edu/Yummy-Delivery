package com.yummy.delivery.service;

import com.yummy.delivery.domain.Store;
import com.yummy.delivery.dto.StoreDTO;
import com.yummy.delivery.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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

}
