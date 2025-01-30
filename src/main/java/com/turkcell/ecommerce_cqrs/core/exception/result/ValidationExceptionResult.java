package com.turkcell.ecommerce_cqrs.core.exception.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationExceptionResult extends ExceptionResult{
    List<String> errors;
    public ValidationExceptionResult(List<String> errors) {
        super("Validation Error");
        this.errors = errors;

    }
}
