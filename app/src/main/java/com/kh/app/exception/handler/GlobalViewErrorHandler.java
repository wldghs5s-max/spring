package com.kh.app.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalViewErrorHandler {

    @ExceptionHandler(Throwable.class)
    public String handle(){
        return "redirect:/error";
    }
}
