package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Menu;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MenuMapper {

    void insertMenu(Menu menu);

}
