package com.yummy.delivery.core.domain;

import com.yummy.delivery.order.dto.CreateOrderRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long userId;

    private Long storeId;

    private Integer storeSellerId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String payType;

    private Integer totalPrice;

    private String address;

    private LocalDateTime createdAt;

    public static Orders create(CreateOrderRequest createOrderRequest,
                                User user,
                                Store store,
                                Function<List<CreateOrderRequest.MenuPair>, Integer> amountFunc) {

        Orders order = new Orders();
        order.userId = user.getId();
        order.storeId = store.getId();
        order.storeSellerId = store.getSellerId();
        order.orderStatus = OrderStatus.REQUEST;
        order.payType = createOrderRequest.getPayType();
        order.totalPrice = amountFunc.apply(createOrderRequest.getMenuPairs());
        order.address = createOrderRequest.getAddress();
        order.createdAt = LocalDateTime.now();

        return order;
    }

    /*
        1. REQUEST
        사용자가 주문을 시도한 시점
        2. CANCEL
        사용자가 주문을 취소
            할수있는 시점 : REQUEST 일때만 가능
        3. ACCEPT
        셀러가 주문을 승낙
        4. REJECT
        셀러가 주문을 거절
        5. COMPLETE
        셀러가 주문을 완료하고, 주문자에게 전달 완료
            -> grade 계산 시점
     */
    public enum OrderStatus {
        REQUEST,
        CANCEL,
        ACCEPT,
        REJECT,
        COMPLETE
    }

    public void cancelOrder() {
        if (orderStatus != OrderStatus.REQUEST) {
            throw new IllegalArgumentException();
        }
        this.orderStatus = OrderStatus.CANCEL;
    }

    public void responseBySeller(boolean isAccepted) {

        if (orderStatus != OrderStatus.REQUEST) {
            throw new IllegalArgumentException("이미 처리 된 주문입니다.");
        }

        this.orderStatus = isAccepted ? OrderStatus.ACCEPT : OrderStatus.REJECT;
    }

    public void confirm() {
        if(orderStatus != OrderStatus.ACCEPT) {
            throw new IllegalArgumentException();
        }

        this.orderStatus = OrderStatus.COMPLETE;
    }
}
