package com.yummy.delivery.user.dto;

import com.yummy.delivery.core.domain.Agree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AgreeRequest {

    @NotNull
    private boolean agreeTerms;

    @NotNull
    private boolean agreeMarketing;
}
