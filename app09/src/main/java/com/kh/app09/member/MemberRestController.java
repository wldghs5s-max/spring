package com.kh.app09.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("join")
    public int join(MemberVo vo){
        int result = memberService.join(vo);
        if(result!=1){
            throw new IllegalStateException("회원가입 실패...");
        }
        return result;
    }

    @PostMapping("login")
    public MemberVo login(MemberVo vo){
        return memberService.login(vo);
    }
}
