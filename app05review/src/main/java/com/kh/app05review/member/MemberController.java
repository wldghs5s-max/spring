package com.kh.app05review.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("member")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("join")
    public int join(MemberVo vo){
        return memberService.join(vo);
    }

    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = memberService.login(vo);
        session.setAttribute("loginMemberVo",loginMemberVo);
        return "login complete!";
    }
    @PutMapping
    public int edit(MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        vo.setNo(no);
        int result = memberService.edit(vo);
        return result;
    }

    @DeleteMapping
    public int delete(HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        return memberService.delete(no);
    }
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginMemberVo");
        return "logout!!";
    }


}



















