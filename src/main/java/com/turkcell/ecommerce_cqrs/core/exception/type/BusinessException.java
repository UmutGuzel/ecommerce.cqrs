package com.turkcell.ecommerce_cqrs.core.exception.type;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
