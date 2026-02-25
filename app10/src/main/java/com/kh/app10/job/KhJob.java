package com.kh.app10.job;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class KhJob {

//    @Scheduled(fixedRate = 5000)
//    public void m01(){
//        log.info("맨처음 실행후 5초마다 실행~~~~");
//    }
//
//    @Scheduled(fixedDelay = 5000)
//    public void m02(){
//        log.info("5초마다 실행~~~");
//    }
    //cron : 초 분 시 일 월 요일
    @Scheduled(cron = "0 */6 * * * *")
    public void m03(){
        log.info("정해진 시간에 실행 ~~");
        System.out.println("new Date() = "+ new Date());
    }










}
