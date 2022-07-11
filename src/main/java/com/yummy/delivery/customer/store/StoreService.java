package com.yummy.delivery.customer.store;

import com.yummy.delivery.admin.store.dto.FindStoreResponse;
import com.yummy.delivery.admin.store.dto.SetUpStoreRequest;
import com.yummy.delivery.core.domain.Store;
import com.yummy.delivery.core.repository.StoreRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service("customer.StoreService")
@RequiredArgsConstructor
public class StoreService {
  private final StoreRepository storeRepository;

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
