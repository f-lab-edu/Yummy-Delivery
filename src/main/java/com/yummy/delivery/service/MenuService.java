package com.yummy.delivery.service;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.mapper.MenuMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public void menuSet(@Param("store_id") int store_id, Menu menu){
        saveInitialTime(menu);
        menu.setStore_id(store_id);
        menuMapper.insertMenu(menu);
    }

    public void saveInitialTime(Menu menu){
        menu.setCreated_at(LocalDateTime.now());
        menu.setUpdated_at(LocalDateTime.now());
    }
}


