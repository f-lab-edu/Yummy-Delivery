package com.yummy.delivery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Menu {

    private Integer id;
    private Integer storeId;
    private String name;
    private Integer price;
    private String photo;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
