package com.site.subrentalcore.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(value = {RestApiException.class})
    protected ResponseEntity<RestApiErrorResponse> handleRestApiException(RestApiException e) {
        return RestApiErrorResponse.toResponseEntity(e);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<RestApiErrorResponse> handleRestApiException(RuntimeException e) {
        return RestApiErrorResponse.toResponseEntity(e);
    }
}
