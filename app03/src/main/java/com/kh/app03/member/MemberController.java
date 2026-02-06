package com.kh.app03.member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("insert")
    @ResponseBody
    public int insert(MemberVo vo){
        int result = memberService.insert(vo);
        return result;
    }

    @GetMapping("list")
    @ResponseBody
    public List<MemberVo> selectList(){
        return memberService.selectList();
    }

    @GetMapping("login")
    @ResponseBody
    public MemberVo login(MemberVo vo, HttpServletRequest req){
        MemberVo dbVo = memberService.login(vo);
        req.getSession().setAttribute("loginMemberVo",dbVo);
        return dbVo;
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute("loginMemberVo");
        return "redirect:/home";
    }

}






