package com.yummy.delivery.service;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.dto.SellerDTO;
import com.yummy.delivery.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerMapper sellerMapper;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder;


  public void signUp(Seller seller){
        encryptedPassword(seller);  //  비밀번호 암호화
        saveInitialTime(seller);    //  생성시간, 수정시간 저장
        sellerMapper.insertSeller(seller);
    }

    public void checkSameEmail(@Param("email") String email){
        if(sellerMapper.isExistsEmail(email)){
            throw new IllegalStateException("사용 중인 이메일입니다");
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
        seller.setCreatedAt(LocalDateTime.now());
        seller.setUpdatedAt(LocalDateTime.now());
    }

    public void login(SellerDTO sellerDTO) {
        String encodingWord = passwordEncoder.encode(sellerDTO.getPassword());

        Seller seller = sellerMapper.findByEmailAndPassword(sellerDTO.getEamil(),
                encodingWord);

        validateExistUser(seller);

        httpSession.setAttribute("SELLER_ID", seller);

    }

    private void validateExistUser(Seller seller) {
        Optional.ofNullable(seller)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void logout() {
        httpSession.removeAttribute("SELLER_ID");
    }

}
