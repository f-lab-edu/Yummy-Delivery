package com.yummy.delivery.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Grade {

    private Long id;

    private Long userId;

    private Integer count;

    private String grade;

}
