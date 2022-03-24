package com.yummy.delivery.service;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.dto.MenuDTO;
import com.yummy.delivery.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public void insertMenu(@Param("storeId") int storeId, MenuDTO menuDTO){

        Menu menu = Menu.builder()
                .storeId(storeId)
                .name(menuDTO.getName())
                .price(menuDTO.getPrice())
                .photo(menuDTO.getPhoto())
                .description(menuDTO.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        menuMapper.insertMenu(menu);
    }


}


