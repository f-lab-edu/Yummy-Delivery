package com.yummy.delivery.exception;

public class UserIdExistedException extends IllegalArgumentException {

    public UserIdExistedException(String message) {
        super(message);
    }
}
