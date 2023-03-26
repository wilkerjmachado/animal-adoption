package com.animals.challenge.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerApi {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {

        return ErrorInfo.builder().message(ex.getMessage()).url(req.getRequestURL().toString()).errorCode(HttpStatus.BAD_REQUEST.value()).build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorInfo handleBadRequestNotFount(HttpServletRequest req, NotFoundException ex) {

        return ErrorInfo.builder().message(ex.getMessage()).url(req.getRequestURL().toString()).errorCode(HttpStatus.NOT_FOUND.value()).build();
    }
}
