package com.yummy.delivery.mapper;

import com.yummy.delivery.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    List<CartDTO> findCartList(@Param("userId") Long userId);

    void deleteAllCartList(@Param("id") Long id);

    void deleteSelectCartList(@Param("userId") Long userId, @Param("menuName") String menuName);
}
