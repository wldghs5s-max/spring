package com.kh.app09.home;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j  //private final Logger log = LoggerFactory.getLogger("HomeController.class");
public class HomeController {

    @GetMapping("home")
    public void home(){
        log.trace("하나");
        log.debug("둘");
        log.info("셋");
        log.warn("넷");
        log.error("다섯");
    }
}
