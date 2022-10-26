package com.yummy.delivery.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CancelOrder {

    @NotBlank
    private Long orderId;

    private Set<Long> couponTicketIds;

}
