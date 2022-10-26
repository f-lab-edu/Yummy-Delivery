package com.yummy.delivery.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long storeId;

    private Long storeSellerId;

    private String name;

    private BigDecimal price;

    private String photo;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
