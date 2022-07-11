package com.yummy.delivery.customer;

import com.yummy.delivery.admin.store.dto.FindStoreResponse;
import com.yummy.delivery.admin.store.dto.SetUpStoreRequest;
import com.yummy.delivery.core.repository.StoreRepository;
import com.yummy.delivery.customer.store.StoreService;

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
