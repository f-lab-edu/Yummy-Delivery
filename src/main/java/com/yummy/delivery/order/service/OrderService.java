package com.yummy.delivery.order.service;

import com.yummy.delivery.core.domain.*;
import com.yummy.delivery.core.repository.*;
import com.yummy.delivery.order.dto.CancelOrder;
import com.yummy.delivery.order.dto.ConfirmOrder;
import com.yummy.delivery.order.dto.CreateOrderRequest;
import com.yummy.delivery.user.service.GradeService;
import com.yummy.delivery.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;
    private final LoginService loginService;
    private final GradeService gradeService;
    private final CouponTicketRepository couponTicketRepository;


    @Transactional
    public Orders create(CreateOrderRequest createOrderRequest) {

        Function<List<CreateOrderRequest.MenuPair>, BigDecimal> amountCalculator = menuPairs -> {

            BigDecimal totalAmount = new BigDecimal("0");

            for (CreateOrderRequest.MenuPair menuPair : menuPairs) {
                Menu menu = menuRepository.findById(menuPair.getMenuId())
                        .orElseThrow(IllegalArgumentException::new);
                BigDecimal amount = menu.getPrice().multiply(menuPair.getMenuVolume());
                totalAmount = totalAmount.add(amount);
            }
            return totalAmount;
        };

        User user = loginService.getLoggedInUserFromDatabase();

        Store store = storeRepository.findById(createOrderRequest.getStoreId())
                .orElseThrow(IllegalArgumentException::new);


        BigDecimal discountPrice = calculateDiscountPrice(createOrderRequest);
        Orders order = Orders.create(createOrderRequest, user, store, amountCalculator, discountPrice);

        if (!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }

        return order;
    }

    @Transactional
    public BigDecimal calculateDiscountPrice(CreateOrderRequest createOrderRequest) {
        User user = loginService.getLoggedInUserFromDatabase();

        Set<Long> couponTicketList = createOrderRequest.getCouponTicketIds();

        BigDecimal discountPrice = new BigDecimal("0");

        for (Long couponTicket : couponTicketList) {

            CouponTicket ticket = couponTicketRepository.findCouponTicketByIdAndUserId(couponTicket, user.getId());

            if(ticket == null) {
                throw new IllegalArgumentException();
            }

            discountPrice = discountPrice.add(ticket.getCoupon().getDiscountPrice());
        }

        return discountPrice;
    }

    @Transactional
    public void cancel(CancelOrder cancelOrder) {

        User user = loginService.getLoggedInUserFromDatabase();

        Orders order = orderRepository.findById(cancelOrder.getOrderId()).
                orElseThrow(IllegalArgumentException::new);

        if (!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }

        List<CouponTicket> couponTickets = couponTicketRepository.findCouponTicketByOrder(order);

        for(CouponTicket couponTicket : couponTickets) {
            couponTicket.cancelTicket();
        }

        couponTicketRepository.saveAll(couponTickets);

        order.cancelOrder();
        orderRepository.save(order);
        gradeService.updateGrade();
    }

    @Transactional
    public void confirm(ConfirmOrder confirmOrder) {

        User user = loginService.getLoggedInUserFromDatabase();

        Orders order = orderRepository.findById(confirmOrder.getOrderId()).
                orElseThrow(IllegalArgumentException::new);

        if (!user.getId().equals(order.getUserId())) {
            throw new IllegalArgumentException();
        }
        order.confirm();

        gradeService.updateGrade();

        orderRepository.save(order);
    }


}