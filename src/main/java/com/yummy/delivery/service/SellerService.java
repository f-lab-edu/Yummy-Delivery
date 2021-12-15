package com.yummy.delivery.service;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.domain.User;
import com.yummy.delivery.mapper.SellerMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SellerService {

    @Autowired SellerMapper sellerMapper;
    @Autowired private PasswordEncoder passwordEncoder;

    public void signUp(Seller seller){
        encryptedPassword(seller);  //  비밀번호 암호화
        saveInitialTime(seller);    //  생성시간, 수정시간 저장
        sellerMapper.insertSeller(seller);
    }

    public void checkSameEmail(@Param("email") String email){
        if(sellerMapper.isExistsEmail(email)){
            throw new IllegalStateException("사욪 중인 이메일입니다");
        }
    }

    public void checkNullData(Seller seller){
        if(seller.getEmail() == null || seller.getPassword() ==null){
            throw new NullPointerException("회원정보를 모두 기입해주세요");
        }
    }

    public void checkPasswordLength(Seller seller){
        if(seller.getPassword().length() < 8){
            throw new IllegalStateException("비밀번호를 8자리 이상 입력해주세요.");
        }
    }

    public void encryptedPassword(Seller seller){
        String encodePassword = passwordEncoder.encode(seller.getPassword());
        seller.setPassword(encodePassword);
    }

    public void saveInitialTime(Seller seller){
        seller.setCreated_at(LocalDateTime.now());
        seller.setUpdated_at(LocalDateTime.now());
    }
}
