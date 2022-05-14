package com.yummy.delivery.service;

import com.yummy.delivery.domain.Store;
import com.yummy.delivery.dto.StoreDTO;
import com.yummy.delivery.mapper.StoreMapper;
import com.yummy.delivery.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreMapper storeMapper;
    private final UserMapper userMapper;

    /* 가게 카테고리 조회 */
    public List<Store> findStoreListByCategory(@Param("category") String category){
        return userMapper.findStoreListByCategory(category);
    }

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
