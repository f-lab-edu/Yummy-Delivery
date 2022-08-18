package com.yummy.delivery.seller.service;

import com.yummy.delivery.core.domain.Seller;
import com.yummy.delivery.core.repository.SellerRepository;
import com.yummy.delivery.seller.dto.UpdateSellerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class ProfileSellerService {

    private final LoginSellerService loginSellerService;
    private final SellerRepository sellerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void update(UpdateSellerRequest updateSellerRequest) {

        Seller seller = loginSellerService.getSellerBySession();
        seller = sellerRepository.findByEmail(seller.getEmail());

        Function<String, String> hashFunc = passwordEncoder::encode;

        seller.update(updateSellerRequest, hashFunc);
        sellerRepository.save(seller);

    }

    @Transactional
    public void delete() {

        Seller seller = loginSellerService.getSellerBySession();
        sellerRepository.deleteById(seller.getId());

    }

}
