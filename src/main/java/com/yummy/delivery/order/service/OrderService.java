package com.yummy.delivery.order.service;

import com.yummy.delivery.core.domain.Menu;
import com.yummy.delivery.core.domain.Orders;
import com.yummy.delivery.core.domain.Store;
import com.yummy.delivery.core.domain.User;
import com.yummy.delivery.core.repository.MenuRepository;
import com.yummy.delivery.core.repository.OrderRepository;
import com.yummy.delivery.core.repository.StoreRepository;
import com.yummy.delivery.core.repository.UserRepository;
import com.yummy.delivery.order.dto.CancelOrder;
import com.yummy.delivery.order.dto.ConfirmOrder;
import com.yummy.delivery.order.dto.CreateOrderRequest;
import com.yummy.delivery.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final LoginService loginService;

    // 주문 시도
    // seller -> 승낙 or 거부
    @Transactional
    public Orders create(CreateOrderRequest createOrderRequest) {

        Function<List<CreateOrderRequest.MenuPair>, Integer> amountCalculator = menuPairs -> {
            int totalAmount = 0;

            for(CreateOrderRequest.MenuPair menuPair : menuPairs) {
                Menu menu = menuRepository.findById(menuPair.getMenuId())
                        .orElseThrow(IllegalArgumentException::new);
                int amount = menu.getPrice() * menuPair.getMenuVolume();
                totalAmount += amount;
            }
            return totalAmount;
        };

        User user = loginService.getLoggedInUserFromDatabase();

        Store store = storeRepository.findById(createOrderRequest.getStoreId())
                .orElseThrow(IllegalArgumentException::new);

        Orders order = Orders.create(createOrderRequest, user, store, amountCalculator);

        if(!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }

        orderRepository.save(order);

        return order;
    }

    @Transactional
    public void cancel(CancelOrder cancelOrder) {

        User user = loginService.getLoggedInUserFromDatabase();

        Orders order = orderRepository.findById(cancelOrder.getOrderId()).
                orElseThrow(IllegalArgumentException::new);

        if(!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }

        order.cancelOrder();
        orderRepository.save(order);
    }

    @Transactional
    public void confirm (ConfirmOrder confirmOrder) {

        User user = loginService.getLoggedInUserFromDatabase();

        Orders order = orderRepository.findById(confirmOrder.getOrderId()).
                orElseThrow(IllegalArgumentException::new);

        if(!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }
        order.confirm();
        orderRepository.save(order);
    }


}