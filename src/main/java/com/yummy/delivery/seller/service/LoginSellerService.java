package com.yummy.delivery.seller.service;

import com.yummy.delivery.core.domain.Seller;
import com.yummy.delivery.core.repository.SellerRepository;
import com.yummy.delivery.seller.dto.LoginSellerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoginSellerService {

    private final PasswordEncoder passwordEncoder;
    private final SellerRepository sellerRepository;
    private final HttpSession httpSession;

    public void login(LoginSellerRequest loginSellerRequest) {

        Seller findSeller = sellerRepository.findByEmail(loginSellerRequest.getLoginId());

        validateExistSeller(findSeller);

        if(!passwordEncoder.matches(loginSellerRequest.getPassword(), findSeller.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        httpSession.setAttribute("SELLER_ID", Seller.builder()
                .id(findSeller.getId())
                .email(loginSellerRequest.getLoginId())
                .password(loginSellerRequest.getPassword())
                .build());

    }

    private void validateExistSeller(Seller seller) {

        Optional.ofNullable(seller)
                .orElseThrow(IllegalArgumentException::new);

    }

    public Seller getSellerBySession() {

        return (Seller) Optional.ofNullable(httpSession.getAttribute("SELLER_ID"))
                .orElseThrow(() -> new IllegalArgumentException("판매자를 찾을 수 없습니다."));

    }

    public void logoutSeller() {

        httpSession.removeAttribute("SELLER_ID");

    }


}
