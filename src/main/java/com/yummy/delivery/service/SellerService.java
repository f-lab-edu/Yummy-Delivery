package com.yummy.delivery.service;

import com.yummy.delivery.domailn.Seller;
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

    public void updateSeller(SellerDTO sellerDTO) {
        Seller seller = sellerMapper.findByEmailAndPassword(sellerDTO.getEamil(),
                sellerDTO.getPassword());

        validateExistUser(seller);

        Seller sellerBuilder = Seller.builder()
                .id(seller.getId())
                .password(sellerDTO.getPassword())
                .address(sellerDTO.getAddress())
                .build();

        sellerMapper.updateByPasswordAndAddress(seller);
    }


}
