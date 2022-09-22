package com.yummy.delivery.core.domain;

import com.yummy.delivery.user.dto.AgreeRequest;
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

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    private Agree agreeTerms;

    @Enumerated(EnumType.STRING)
    private Agree agreeMarketing;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static User create(CreateUserRequest createUserRequest, String hashedPassword) {
        User user = new User();
        user.email = createUserRequest.getEmail();
        user.password = hashedPassword;
        user.name = createUserRequest.getName();
        user.address = createUserRequest.getAddress();
        user.phone = createUserRequest.getPhone();
        user.grade = Grade.BRONZE;
        user.agreeTerms = Agree.N;
        user.agreeMarketing = Agree.N;
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    public void update(UpdateUserRequest updateUserRequest, Function<String, String> hashFunc) {

        if (StringUtils.isNotEmpty(updateUserRequest.getPassword())) {
            this.password = hashFunc.apply(updateUserRequest.getPassword());
        }

        if (StringUtils.isNotEmpty(updateUserRequest.getPhone())) {
            this.phone = updateUserRequest.getPhone();
        }

        if (StringUtils.isNotEmpty(updateUserRequest.getAddress())) {
            this.address = updateUserRequest.getAddress();
        }
    }

    public enum Grade {
        BRONZE, SILVER, GOLD, PLATINUM;

        public static Grade getGradeByOrderCount(Long orderCount) {
            if(orderCount <= 5) {
                return BRONZE;
            } else if(orderCount <= 10) {
                return SILVER;
            } else if(orderCount <= 20) {
                return GOLD;
            } else {
                return PLATINUM;
            }
        }
    }

    public void updateGrade(Grade grade) {
        this.grade = grade;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateAgree(AgreeRequest agreeRequest) {

        this.agreeTerms = agreeRequest.isAgreeTerms() ? Agree.Y : Agree.N;

        this.agreeMarketing = agreeRequest.isAgreeMarketing() ? Agree.Y : Agree.N;
    }
}
