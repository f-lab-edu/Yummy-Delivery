package com.yummy.delivery.core.domain;

import com.yummy.delivery.store.dto.CreateStoreRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int sellerId;

    private String name;

    private String phone;

    private String address;

    private String category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Store create(CreateStoreRequest createStoreRequest) {
        Store store = new Store();
        store.sellerId = 1;
        store.name = createStoreRequest.getName();
        store.phone = createStoreRequest.getPhone();
        store.address = createStoreRequest.getAddress();
        store.category = createStoreRequest.getCategory();
        store.createdAt = LocalDateTime.now();
        store.updatedAt = LocalDateTime.now();
        return store;
    }

}
