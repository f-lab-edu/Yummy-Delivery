package com.yummy.delivery.service;

import com.yummy.delivery.domain.Order;
import com.yummy.delivery.dto.RequestOrderDTO;
import com.yummy.delivery.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;

    public void registerOrder(RequestOrderDTO requestOrderDTO) {

        Order order = Order.builder()
                .id(requestOrderDTO.getId())
                .userId(requestOrderDTO.getUserId())
                .storeId(requestOrderDTO.getStoreId())
                .payType(requestOrderDTO.getPayType())
                .totalType(requestOrderDTO.getTotalPrice())
                .address(requestOrderDTO.getAddress())
                .build();

        orderMapper.insertOrder(order);
    }

}
