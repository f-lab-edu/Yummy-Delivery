package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Seller;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {

    void insertSeller(Seller seller);

    boolean isExistsEmail(String email);
}
