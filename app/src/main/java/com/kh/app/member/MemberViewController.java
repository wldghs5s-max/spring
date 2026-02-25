package com.kh.app.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberViewController {
    @GetMapping("join")
    public void join(){}

    @GetMapping("mypage")
    public void mypage(){}
}
