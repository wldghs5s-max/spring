package com.kh.app06.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("join")
    public int join(@RequestBody MemberVo vo){
        return memberService.join(vo);
    }

    //로그인
    @PostMapping("login")
    public String login(@RequestBody MemberVo vo , HttpSession session){
        MemberVo loginMembervo = memberService.login(vo);
        if(loginMembervo==null){
            return """
                    {"msg":"BAD"}
                    """;
        }
        session.setAttribute("loginMemberVo",loginMembervo);
        return """
                {"msg":"GOOD"}
                """;
    }

    //닉네임변경
    @PutMapping
    public int editNick(@RequestBody MemberVo vo , HttpSession session){
        MemberVo loginMemberVo = ((MemberVo)session.getAttribute("loginMemberVo"));
        String no = loginMemberVo.getNo();
        vo.setNo(no);
        if(loginMemberVo==null){
            throw new IllegalArgumentException("로그인 먼저 하세요");
        }
        int result  = memberService.editNick(vo);
        return result;
    }

    //탈퇴하기
    @DeleteMapping
    public int quit(HttpSession session){
        MemberVo loginMemberVo = ((MemberVo)session.getAttribute("loginMemberVo"));
        if(loginMemberVo==null){
            throw new IllegalArgumentException("로그인 먼저 하세요");
        }
        String no = loginMemberVo.getNo();

        int result = memberService.quit(no);
        if(result==1){
            session.removeAttribute("loginMemberVo");
        }
        return result;
    }




}







