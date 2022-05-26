package com.yummy.delivery.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MenuResponseDTO {

    private List<MenuFindResponseDTO> menuFindResponse;

}
