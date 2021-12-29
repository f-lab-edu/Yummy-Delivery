package com.yummy.delivery.service;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public void menuSet(@Param("storeId") int storeId, Menu menu){
        saveInitialTime(menu);
        menu.setStoreId(storeId);
        menuMapper.insertMenu(menu);
    }

    public void saveInitialTime(Menu menu){
        menu.setCreatedAt(LocalDateTime.now());
        menu.setUpdatedAt(LocalDateTime.now());
    }
}


