package com.yummy.delivery.service;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public void insertMenu(@Param("storeId") int storeId, Menu menu){
        insertCreatedTimeAndUpdatedTime(menu);
        menu.setStoreId(storeId);
        menuMapper.insertMenu(menu);
    }

    public void insertCreatedTimeAndUpdatedTime(Menu menu){
        menu.setCreatedAt(LocalDateTime.now());
        menu.setUpdatedAt(LocalDateTime.now());
    }
}


