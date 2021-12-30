package com.yummy.delivery.httpStatus;

import org.springframework.http.ResponseEntity;

public class httpComponent {

    public static final ResponseEntity<Void> RESPONSE_ENTITY_OK =
            ResponseEntity.ok().build();
}