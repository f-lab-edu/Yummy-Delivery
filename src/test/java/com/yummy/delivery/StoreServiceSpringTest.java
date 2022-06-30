package com.yummy.delivery;

import com.yummy.delivery.core.repository.StoreRepository;
import com.yummy.delivery.store.StoreService;
import com.yummy.delivery.store.dto.FindStoreResponse;
import com.yummy.delivery.store.dto.SetUpStoreRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class StoreServiceSpringTest {
  @Autowired StoreRepository storeRepository;
  @Autowired StoreService storeService;

  @Transactional
  @Test
  void setUp() {
    // given
    Long sellerId = 1L;
    SetUpStoreRequest setUpStoreRequest = new SetUpStoreRequest();
    setUpStoreRequest.setName("조셉-가게1");
    setUpStoreRequest.setPhone("010123123");
    setUpStoreRequest.setAddress("경기 광주");
    setUpStoreRequest.setCategory("한식");

    // when
    storeService.setUpStore(sellerId, setUpStoreRequest);

    // then
    // exception 안나면 성공
    System.out.println("성공");
  }

  @Transactional
  @Test
  public void findAllByQuery() {
    // given
    String category = "한식";
    String address = "경기 광주";

    // when
    List<FindStoreResponse> responses =
        storeService.findAllByCategoryAndAddress(category, address);

    // then
    System.out.println(responses);
    Assertions.assertNotNull(responses);
  }
}
