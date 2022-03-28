package com.yummy.delivery.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CartDTO {

    private Long id;
    private Long userId;
    private String storeName;
    private String menuName;
    private String menuDescription;
    private String menuPhoto;
    private Long menuPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
