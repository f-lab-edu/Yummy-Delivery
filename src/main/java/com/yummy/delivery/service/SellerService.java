package com.yummy.delivery.service;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SellerService {

    @Autowired SellerMapper sellerMapper;
    @Autowired private PasswordEncoder passwordEncoder;

    public void signUp(Seller seller){

        if(sellerMapper.isExistsEmail(seller.getEmail())){
            throw new IllegalStateException("Same Email existed : " + seller.getEmail());
        }

        if(seller.getPassword().length() < 8){
            throw new IllegalStateException("Password must be at least 8.");
        }

        String encodePassword = passwordEncoder.encode(seller.getPassword());

        seller.setPassword(encodePassword);
        seller.setCreated_at(LocalDateTime.now());
        seller.setUpdated_at(LocalDateTime.now());

        sellerMapper.insertSeller(seller);
    }
}
