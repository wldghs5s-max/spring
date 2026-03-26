package com.kh.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalApiErrorHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<HashMap<String, Object>> handle(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMsg",e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(map);
    }
}
