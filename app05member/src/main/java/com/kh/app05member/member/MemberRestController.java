package com.kh.app05member.member;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("member")
public class MemberRestController {

    @Autowired
    private MemberService memberService;
    //회원가입
    @PostMapping("join")
    public int join(@RequestBody MemberVo vo){

        return memberService.join(vo);
    }
    //로그인
    @PostMapping("login")
    public String login(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = memberService.login(vo);
        session.setAttribute("loginMemberVo",loginMemberVo);
        if(loginMemberVo==null){
            throw new IllegalArgumentException();
        }
        return "1";
    }

    @PutMapping("mypage")
    public int edit(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        vo.setNo(no);
        return memberService.edit(vo);
    }

    @DeleteMapping("mypage")
    public int delete(HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        session.removeAttribute("loginMemberVo");
        return memberService.delete(no);
    }


}
