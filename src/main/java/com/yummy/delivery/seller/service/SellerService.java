package com.yummy.delivery.seller.service;

import com.yummy.delivery.core.domain.Seller;
import com.yummy.delivery.core.repository.SellerRepository;
import com.yummy.delivery.seller.dto.CreateSellerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final PasswordEncoder passwordEncoder;
    private final SellerRepository sellerRepository;

    @Transactional
    public Seller signUp(CreateSellerRequest createSellerRequest) {

        boolean existsEmail = sellerRepository.existsByEmailEqualsIgnoreCase(createSellerRequest.getEmail());

        if(existsEmail) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        String hashed = passwordEncoder.encode(createSellerRequest.getPassword());

        Seller seller = Seller.create(createSellerRequest, hashed);

        return sellerRepository.save(seller);

    }


}
