package com.kh.app11.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Aspect
@Slf4j
public class HelloWorld {

//    @Before("execution(public int com.kh.app11.book.BookService.insert(com.kh.app11.book.BookVo))")
//    public void m01(){
//        log.info("HelloWorld.before");
//    }
//
//    @After("execution(public int com.kh.app11.book.BookService.insert(com.kh.app11.book.BookVo))")
//    public void m02(){
//        log.info("HelloWorld.after");
//    }

//    @Around("execution(public * com.kh.app11.*.*Service.*(..))")
//    @Around("@annotation(com.kh.app11.aop.KhTimer)")
    public Object m03(ProceedingJoinPoint jp) throws Throwable {
        log.info("HelloWorld.Around");
        Object result = jp.proceed();
        log.info("~~~");
        return result;
    }
}
