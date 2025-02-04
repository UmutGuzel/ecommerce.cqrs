package com.turkcell.ecommerce_cqrs.core.exception;



import com.turkcell.ecommerce_cqrs.core.exception.result.BusinessExceptionResult;
import com.turkcell.ecommerce_cqrs.core.exception.result.ExceptionResult;
import com.turkcell.ecommerce_cqrs.core.exception.result.ValidationExceptionResult;
import com.turkcell.ecommerce_cqrs.core.exception.type.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//global exception handler olduğunu söylüyoruz
//RestControllerdaki hatalarıon danışacağı yer
@RestControllerAdvice
public class GlobalExceptionHandler {

    //İş kuralı Hataları
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessExceptionResult handlerRuntimeException(BusinessException e) {
        return new BusinessExceptionResult(e.getMessage());
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult handlerException(Exception e) {
        return new ExceptionResult("Internal Server Error");
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ValidationExceptionResult(e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map((error) ->error.getDefaultMessage())
                .toList());
    }

}
