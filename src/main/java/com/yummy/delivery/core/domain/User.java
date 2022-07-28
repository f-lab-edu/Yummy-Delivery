package com.yummy.delivery.core.domain;

import com.yummy.delivery.user.dto.CreateUserRequest;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User {

  @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  private String email;
  private String password;
  private String name;
  private String phone;
  private String address;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Integer gradeId;

  public static User create(CreateUserRequest createUserRequest, String hashedPassword) {
    User user = new User();
    user.email = createUserRequest.getEmail();
    user.password = hashedPassword;
    user.name = createUserRequest.getName();
    user.phone = createUserRequest.getPhone();
    user.address = createUserRequest.getAddress();
    user.createdAt = LocalDateTime.now();
    user.updatedAt = LocalDateTime.now();
    user.gradeId = 1;
    return user;
  }
}
