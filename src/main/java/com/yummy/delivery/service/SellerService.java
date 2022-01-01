package com.yummy.delivery.service;

import com.yummy.delivery.domain.Seller;
import com.yummy.delivery.dto.SellerDTO;
import com.yummy.delivery.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerMapper sellerMapper;
    private final HttpSession httpSession;
    private final PasswordEncoder passwordEncoder;

    public void login(SellerDTO sellerDTO) {
        String encodingWord = passwordEncoder.encode(sellerDTO.getPassword());

        Seller seller = sellerMapper.findByEmailAndPassword(sellerDTO.getEmail(),
                encodingWord);

        validateExistUser(seller);

        httpSession.setAttribute("SellerID", seller);

    }

    private void validateExistUser(Seller seller) {
        Optional.ofNullable(seller)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void logout() {
        httpSession.removeAttribute("SellerID");
    }

    public void updateSeller(SellerDTO sellerDTO) {
        Seller sellerSession = (Seller) httpSession.getAttribute("SellerID");

        Seller seller = sellerMapper.findByEmail(sellerSession.getEmail());

        validateExistUser(seller);

        Seller sellerBuilder = Seller.builder()
                .id(seller.getId())
                .password(sellerDTO.getPassword())
                .address(sellerDTO.getAddress())
                .build();

        sellerMapper.updateByPasswordAndAddress(seller);
    }


}
