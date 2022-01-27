package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {

    @Insert("INSERT INTO Store (id, seller_id, name, phone, address, category, created_at, updated_at) " +
            "VALUES(#{id}, #{sellerId}, #{name}, #{phone}, #{address}, #{category}, #{createdAt}, #{updatedAt})")
    void insertStore(Store store);
}
