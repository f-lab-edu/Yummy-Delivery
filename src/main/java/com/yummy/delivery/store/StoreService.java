package com.yummy.delivery.store;

import com.yummy.delivery.core.domain.Store;
import com.yummy.delivery.core.repository.StoreRepository;
import com.yummy.delivery.store.dto.FindStoreResponse;
import com.yummy.delivery.store.dto.SetUpStoreRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
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

  // TODO Query filter..
  // 앱 키면 -> 한식 검색 -> 가게나오는 메뉴
  // address && category
  public List<FindStoreResponse> findAllByCategoryAndAddress(String category, String address) {
    // 카테고리와 주소를 동시에 지정해서 조회함
    // 주소는 1레벨까지만
    // ex ) 서울, 경기 화성, 경기 광주, 경기 과천, 경기 안산 등등
    // category 는 항상 세팅돼서 들어옴
    // address 도 항상 세팅됨
    if (StringUtils.isBlank(address) || StringUtils.isBlank(category)) {
      throw new IllegalArgumentException("잘못된 검색 설정");
    }

    return storeRepository.findAllByAddressEqualsAndCategoryEquals(address, category)
        .stream()
        .map(store -> new FindStoreResponse(
            store.getSellerId(),
            store.getName(), store.getPhone(),
            store.getAddress(), null, // TODO thumbnail
            store.getCreatedAt(), store.getUpdatedAt()
        ))
        .collect(Collectors.toList());
  }
}
