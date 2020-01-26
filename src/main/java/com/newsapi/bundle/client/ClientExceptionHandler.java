package com.newsapi.bundle.client;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler({FeignException.NotFound.class, FeignException.InternalServerError.class,FeignException.BadGateway.class,FeignException.FeignServerException.class,FeignException.GatewayTimeout.class})
    public ResponseEntity <String> handleException(FeignException e) {
        return ResponseEntity.status (e.status ()).body (HttpStatus.valueOf (e.status ()).getReasonPhrase ());
    }
}
