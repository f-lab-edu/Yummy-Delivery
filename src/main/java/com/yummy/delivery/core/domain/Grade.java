package com.yummy.delivery.core.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Grade {
  @Id
  private Integer id;
  private Integer count;
  private String grade;
}
