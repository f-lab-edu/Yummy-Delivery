package com.yummy.delivery;

import com.yummy.delivery.admin.menu.MenuService;
import com.yummy.delivery.admin.menu.dto.CreateMenuRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class MenuServiceSpringTest {
  @Autowired MenuService menuService;

  @Transactional
  @Test
  void createMenu() {
    // given
    CreateMenuRequest createMenuRequest = new CreateMenuRequest(
        1L, "pizza2", BigDecimal.TEN, "", "pizza"
    );


    // when
    menuService.createMenu(createMenuRequest);

    // then
    // exception 안나면 성공
  }

  @Transactional
  @Test
  public void findAllByQuery() {
  }
}
