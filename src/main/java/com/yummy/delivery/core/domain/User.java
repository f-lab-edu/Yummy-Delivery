package com.yummy.delivery.core.domain;

import com.yummy.delivery.user.dto.CreateUserRequest;
import com.yummy.delivery.user.dto.UpdateUserRequest;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.function.Function;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        user.address = createUserRequest.getAddress();
        user.phone = createUserRequest.getPhone();
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        user.gradeId = 1;
        return user;
    }

    public void update(UpdateUserRequest updateUserRequest, Function<String, String> hashFunc) {

        if(StringUtils.isNotEmpty(updateUserRequest.getPassword())) {
            this.password = hashFunc.apply(updateUserRequest.getPassword());
        }

        if(StringUtils.isNotEmpty(updateUserRequest.getPhone())) {
            this.phone = updateUserRequest.getPhone();
        }

        if(StringUtils.isNotEmpty(updateUserRequest.getAddress())) {
            this.address = updateUserRequest.getAddress();
        }


    }
}
