package com.yummy.delivery.admin.menu;

import com.yummy.delivery.admin.menu.dto.CreateMenuRequest;
import com.yummy.delivery.core.domain.Menu;
import com.yummy.delivery.core.repository.MenuRepository;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("admin.MenuService")
public class MenuService {
  private final MenuRepository menuRepository;


  @Transactional
  public void createMenu(CreateMenuRequest createMenuRequest) {
    // 가게마다 동일한 이름의 메뉴는 하나만 존재함
    List<Menu> menuList = menuRepository.findAllByStoreId(createMenuRequest.getStoreId());
    boolean existMenu = menuList.stream()
        .anyMatch(menu -> menu.getName().equals(createMenuRequest.getName()));
    if (existMenu) {
      throw new IllegalArgumentException("동일한 메뉴가 존재합니다.");
    }

    Menu menu = new Menu(null, createMenuRequest.getStoreId(),
        createMenuRequest.getName(), createMenuRequest.getPrice(),
        createMenuRequest.getPhoto(), createMenuRequest.getDescription(),
        LocalDateTime.now(), LocalDateTime.now());

    menuRepository.save(menu);
  }

  @Transactional
  public void modifyMenu() {

  }

  @Transactional
  public void removeMenu(Long menuId) {
    menuRepository.findById(menuId).ifPresent(menuRepository::delete);
  }

}
