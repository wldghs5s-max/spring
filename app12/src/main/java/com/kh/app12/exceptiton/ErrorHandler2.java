package com.kh.app12.exceptiton;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler2 {

    @ExceptionHandler(Exception.class)
    public String m01(){
        return "zzz";
    }
}
