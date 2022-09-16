package com.yummy.delivery.order.service;

import com.yummy.delivery.core.domain.Orders;
import com.yummy.delivery.core.domain.Seller;
import com.yummy.delivery.core.repository.OrderRepository;
import com.yummy.delivery.order.dto.ResponseOrder;
import com.yummy.delivery.seller.service.LoginSellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SellerOrderService {

    private OrderRepository orderRepository;
    private LoginSellerService loginSellerService;

    @Transactional
    public void responseOrder(ResponseOrder responseOrder) {

        Seller seller =  loginSellerService.getSellerBySession(); //셀러의 세션

        Orders orders = orderRepository.findById(responseOrder.getOrderId())
                .orElseThrow(IllegalArgumentException::new);

        if(!seller.getId().equals(orders.getStoreSellerId())) {
            throw new IllegalArgumentException();
        }

        orders.responseBySeller(responseOrder.getIsAccepted());
        orderRepository.save(orders);
    }

}
