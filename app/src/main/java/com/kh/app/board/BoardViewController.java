package com.kh.app.board;

import com.kh.app.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
@Slf4j
@RequiredArgsConstructor
public class BoardViewController {
    private final BoardService boardService;

    @GetMapping("insert")
    public void insert(HttpSession session){
        if (session.getAttribute("loginMemberVo")==null){
            throw new IllegalStateException("login plz...");
        }
    }

    @GetMapping("list/{pno}")
    public String list(){
        return "board/list";
    }

    @GetMapping("detail/{no}")
    public String detail(){
        return "board/detail";
    }

    @GetMapping("edit/{no}")
    public String edit(@PathVariable String no, Model model, HttpSession session) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            throw new IllegalStateException("로그인 하고 오세요");
        }
        String loginMemberNo = loginMemberVo.getNo();
        BoardVo boardVo = boardService.selectOne(no);
        if (!loginMemberNo.equals(boardVo.getWriterNo())) {
            throw new IllegalStateException("로그인 정보 불일치");
        }
        model.addAttribute("boardVo", boardVo);

        return "board/edit";
    }

}
