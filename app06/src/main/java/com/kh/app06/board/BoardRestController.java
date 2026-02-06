package com.kh.app06.board;

import com.kh.app06.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardRestController {
    private final BoardService boardService;

    //게시글 작성
    @PostMapping
    public int insert(@RequestBody BoardVo vo , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if(loginMemberVo==null){
            throw new IllegalStateException("로그인하고와라");
        }
        vo.setWriterNo(loginMemberVo.getNo());
        return boardService.insert(vo);
    }

    //게시글 목록조회(+검색)
    @GetMapping
    public List<BoardVo> selectList(@RequestBody BoardVo vo , HttpSession session){
        List<BoardVo> voList = boardService.selectList();
        return voList;
    }
    //게시글 상세조회
    @GetMapping("{no}")
    public BoardVo selectByNo(@PathVariable String no){
        return boardService.selectByNo(no);
    }
    //게시글 제목, 내용 수정
    @PutMapping
    public int update(@RequestBody BoardVo vo , HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if(loginMemberVo == null){
            throw new IllegalStateException();
        }
        vo.setWriterNo(loginMemberVo.getNo());
        int result = boardService.update(vo);
        return result;
    }
    //게시글 삭제
    @DeleteMapping
    public int delete(@RequestBody Map<String,String> map, HttpSession session){
        String no = map.get("no");
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if(loginMemberVo ==null){
            throw new IllegalStateException("로그인 하세요");
        }
        BoardVo boardVo = new BoardVo();
        boardVo.setWriterNo(loginMemberVo.getNo());
        boardVo.setNo(no);
        int result = boardService.delete(boardVo);
        return result;
    }

}
