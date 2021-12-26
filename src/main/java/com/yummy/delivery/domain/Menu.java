package com.yummy.delivery.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Menu {

    private int id;
    private int store_id;
    private String name;
    private int price;
    private String photo;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
