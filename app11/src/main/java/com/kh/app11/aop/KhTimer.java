package com.kh.app11.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class KhTimer {

    @Around("@annotation(com.kh.app11.aop.TimerAnno)")
    public Object checkSqlTime(ProceedingJoinPoint jp) throws Throwable{
        long start = System.nanoTime();
        Object result = jp.proceed();
        long end = System.nanoTime();
        long time = end - start;
        String name = jp.getSignature().toShortString();
        log.info("{} 실행 시간 : {}",name,time);
        return result;
    }
}
