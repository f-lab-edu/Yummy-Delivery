package com.yummy.delivery.exception;

public class UserNotFoundException extends IllegalArgumentException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
