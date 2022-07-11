package com.yummy.delivery.admin.store;

import com.yummy.delivery.admin.store.dto.SetUpStoreRequest;
import com.yummy.delivery.core.domain.Store;
import com.yummy.delivery.core.repository.StoreRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

@Service("admin.StoreService")
@RequiredArgsConstructor
public class StoreService {
  private final StoreRepository storeRepository;
  /*
   가게이름 등록 시, 가게이름 중복 검사를 실행한다.
   가게는 최소 한개 이상의 음식을 등록해야한다.
   판매자가 사용자의 배달주문을 수락하면 사용자는 더 이상 취소할 수 없다.

   등록기능
    가게 등록 기능
    가게 메뉴 등록 / 수정 / 삭제 기능
   */

  /*
    판매자?

      가게 정보 CRUD
        ->
      가게 메뉴 관리 CRUD
   */

  @Transactional
  public void setUpStore(Long sellerId, SetUpStoreRequest setUpStoreRequest) {
    boolean isExist = storeRepository.existsByNameEquals(setUpStoreRequest.getName());
    if (isExist) {
      throw new IllegalArgumentException("가게 이름이 중복됩니다.");
    }

    Store store = new Store(
        null, sellerId, setUpStoreRequest.getName(),
        setUpStoreRequest.getPhone(),
        setUpStoreRequest.getAddress(),
        setUpStoreRequest.getCategory(),
        LocalDateTime.now(), LocalDateTime.now()
    ); //
    storeRepository.save(store);
  }
}
