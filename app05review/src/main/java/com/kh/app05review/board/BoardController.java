package com.kh.app05review.board;

import com.kh.app05review.member.MemberService;
import com.kh.app05review.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private MemberService memberService;

    @GetMapping("write")
    public String write(HttpSession session) throws Exception {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if(loginMemberVo==null){
            throw new Exception("로그인부터 하세요.");
        }
        return "/board/write";
    }
    @PostMapping("write")
    public int write(BoardVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String writerNo = loginMemberVo.getNo();
        vo.setWriterNick(writerNo);

        return boardService.write(vo);
    }
    @GetMapping
    public List<BoardVo> selectList(HttpSession session){
        List<MemberVo> memberVoList = memberService.selectList();
        List<BoardVo> boardVoList = boardService.selectList();
        Map<String, String> memberNickMap = new HashMap<>();
        for (MemberVo memberVo : memberVoList) {
            memberNickMap.put(memberVo.getNo(), memberVo.getNick());
        }

        for (BoardVo boardVo : boardVoList) {
            String nick = memberNickMap.get(boardVo.getWriterNo());
            if (nick != null) {
                boardVo.setWriterNick(nick);
            }
        }
        return boardVoList;
    }
}
