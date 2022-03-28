package com.yummy.delivery.mapper;

import com.yummy.delivery.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    List<CartDTO> findCartList(@Param("userId") Long userId);
}
