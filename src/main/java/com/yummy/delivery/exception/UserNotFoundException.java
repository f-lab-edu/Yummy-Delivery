package com.yummy.delivery.exception;

public class UserNotFoundException extends NullPointerException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
