package com.yummy.delivery.core.domain;

import com.yummy.delivery.seller.dto.CreateSellerRequest;
import com.yummy.delivery.seller.dto.UpdateSellerRequest;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.function.Function;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String email;

    private String password;

    private String phone;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Seller create(CreateSellerRequest createSellerRequest, String hashedPassword) {
        Seller seller = new Seller();
        seller.email = createSellerRequest.getEmail();
        seller.password = hashedPassword;
        seller.phone = createSellerRequest.getPhone();
        seller.name = createSellerRequest.getPhone();
        seller.createdAt = LocalDateTime.now();
        seller.updatedAt = LocalDateTime.now();

        return seller;
    }

    public void update(UpdateSellerRequest updateSellerRequest, Function<String, String> hashFunc) {

        if(StringUtils.isNotEmpty(updateSellerRequest.getPassword())) {
            this.password = hashFunc.apply(updateSellerRequest.getPassword());
        }

        if(StringUtils.isNotEmpty(updateSellerRequest.getPhone())) {
            this.phone = updateSellerRequest.getPhone();
        }

    }

}
