package com.yummy.delivery.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MenuFindResponseDTO {

    private Integer id;
    private Integer storeId;
    private String name;
    private Integer price;
    private String photo;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
