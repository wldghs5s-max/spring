package com.kh.app12.exceptiton;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public final class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public String m02(){
        System.out.println("Exception ~~~");
        return "redirect:/err";
    }

}
