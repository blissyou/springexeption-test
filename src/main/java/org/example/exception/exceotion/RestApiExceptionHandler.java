package org.example.exception.exceotion;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.model.Api;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@Slf4j
//아래 어노테이션은 예외를 감지하는 어노테이션
@RestControllerAdvice(basePackages = "org.example.exception")
@Order(1)
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
           log.error("IndexOutOfBoundsException",e);
           return ResponseEntity.status(200).build();
    }
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ){
        log.error("",e);
        var response =  Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resulMessage(HttpStatus.NOT_FOUND.name())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);


    }
}
