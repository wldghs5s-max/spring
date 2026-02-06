package com.kh.app05member.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("member")
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    //회원가입 화면
    @GetMapping("join")
    public void join(){}

    //로그인 화면
    @GetMapping("login")
    public void login(){}

    @GetMapping("mypage")
    public void mypage(){}
}
