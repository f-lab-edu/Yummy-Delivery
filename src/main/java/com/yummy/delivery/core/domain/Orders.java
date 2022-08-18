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

    private Integer userGradeId;

    private Integer storeSellerId;

    private String payType;

    private Integer totalPrice;

    private String address;

    private LocalDateTime createdAt;

    public static Orders create(CreateOrderRequest createOrderRequest,
                                User user,
                                Store store,
                                Function<List<CreateOrderRequest.MenuPair>,Integer> amountFunc) {
        Orders order = new Orders();
        order.userId = user.getId();
        order.storeId = store.getId();
        order.userGradeId = user.getGradeId();
        order.storeSellerId = store.getSellerId();
        order.payType = createOrderRequest.getPayType();
        order.totalPrice = amountFunc.apply(createOrderRequest.getMenuPairs());
        order.address = createOrderRequest.getAddress();
        order.createdAt = LocalDateTime.now();

        return order;
    }
}
