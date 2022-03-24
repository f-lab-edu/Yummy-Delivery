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


    public void signUp(SellerDTO sellerDTO){
        checkIncludeSpace(sellerDTO);
        Seller seller = Seller.builder()
                .email(sellerDTO.getEmail())
                .password(encryptedPassword(sellerDTO))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        sellerMapper.insertSeller(seller);
    }

    public void checkSameEmail(@Param("email") String email){
        if(sellerMapper.isExistsEmail(email)){
            throw new IllegalStateException("사용 중인 이메일입니다");
        }
    }

    public void checkNullData(SellerDTO sellerDTO){
        if(sellerDTO.getEmail() == null || sellerDTO.getPassword() == null){
            throw new NullPointerException("회원정보를 모두 기입해주세요");
        }
    }

    /* 이메일(아이디), 비밀번호, 이름 공백문자 검사 */
    public void checkIncludeSpace(SellerDTO sellerDTO){
        if(sellerDTO.getEmail().indexOf(" ") != -1){
            throw new IllegalStateException("이메일에 공백 값이 포함되어있습니다!!");
        }
        else if(sellerDTO.getPassword().indexOf(" ") != -1){
            throw new IllegalStateException("비밀번호에 공백 값이 포함되어있습니다!!");
        }
    }

    public void checkPasswordLength(SellerDTO sellerDTO){
        if(sellerDTO.getPassword().length() < 8){
            throw new IllegalStateException("비밀번호를 8자리 이상 입력해주세요.");
        }
    }

    public String encryptedPassword(SellerDTO sellerDTO){
        String encodePassword = passwordEncoder.encode(sellerDTO.getPassword());
        return encodePassword;
    }

    public void login(SellerDTO sellerDTO) {
        String encodingWord = passwordEncoder.encode(sellerDTO.getPassword());

        Seller seller = sellerMapper.findByEmailAndPassword(sellerDTO.getEmail(),
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
