package com.turkcell.ecommerce_cqrs.core.pipelines.validation;

import an.awesome.pipelinr.Command;
import com.turkcell.ecommerce_cqrs.core.pipelines.exceptions.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ValidationBehavior implements Command.Middleware {
    private final Validator validator;

    @Override
    public <R, C extends Command<R>> R invoke(C c, Next<R> next) {
        Set<ConstraintViolation<C>> violations = validator.validate(c);
        if(!violations.isEmpty()) {
            throw new ValidationException(violations.stream().map(ConstraintViolation::getMessage).toList());
        }
        return next.invoke();
    }
}
