package com.yummy.delivery.store.service;

import com.yummy.delivery.core.domain.Store;
import com.yummy.delivery.core.repository.StoreRepository;
import com.yummy.delivery.store.dto.CreateStoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional
    public Store create(CreateStoreRequest createStoreRequest) {

        boolean existsStore = storeRepository.existsByNameAndAddressEqualsIgnoreCase(
                createStoreRequest.getName(), createStoreRequest.getAddress()
        );

        if(existsStore) {
            throw new IllegalArgumentException("이미 존재하는 매장입니다.");
        }

        Store store = Store.create(createStoreRequest);

        return storeRepository.save(store);

    }
}
