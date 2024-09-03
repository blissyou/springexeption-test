package org.example.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number format exception");

    }
//    @ExceptionHandler(value = {NumberFormatException.class})
//    public ResponseEntity numberformatException(
//            NumberFormatException e
//    ){
//        log.error("RestApiController", e);
//        return ResponseEntity.ok().build();
//    }
}
