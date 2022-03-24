package com.yummy.delivery.mapper;

import com.yummy.delivery.domain.Menu;
import com.yummy.delivery.domain.Store;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Insert("INSERT INTO Store (id, seller_id, name, phone, address, category, created_at, updated_at) " +
            "VALUES(#{id}, #{sellerId}, #{name}, #{phone}, #{address}, #{category}, #{createdAt}, #{updatedAt})")
    void insertStore(Store store);

    @Select("SELECT m.id, m.store_id, m.name, m.price, m.photo, m.description, m.created_at, m.updated_at " +
            "FROM menu m " +
            "INNER JOIN store s " +
            "ON s.id = m.store_id " +
            "WHERE s.id = #{storeId}")
    List<Menu> findStoreMenu(long storeId);

}
