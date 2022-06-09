package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MenuMapper {

    void insertMenu(Menu menu);

    Menu findByMenuId(Long menuId);

    List<Menu> findByMenuIds(List<Long> menuIds);
}
