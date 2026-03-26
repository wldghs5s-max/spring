package com.kh.app.board;

import com.kh.app.member.MemberVo;
import com.kh.app.util.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
@Slf4j
public class BoardRestController {
    private final BoardService boardService;

    @Value("${page.pageLimit}")
    private int pageLimit;
    @Value("${page.boardLimit}")
    private int boardLimit;

    @PostMapping("insert")
    public ResponseEntity<Map<String, String>> insert(@RequestBody BoardVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        log.error("loginMemberVo : "+loginMemberVo);
        String loginMemberNo = loginMemberVo.getNo();
        vo.setWriterNo(loginMemberNo);
        int result = boardService.insert(vo);
        if(result!=1){
            String errMsg = "[B-100]insert err...";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        Map<String,String> map = new HashMap<>();
        map.put("result",result+"");
        return ResponseEntity.ok(map);
    }
    @GetMapping
    public ResponseEntity<HashMap<String, Object>> selectList(int currentPage){
        int listCount = boardService.selectCount();
        int pageLimit = this.pageLimit;
        int boardLimit = this.boardLimit;

        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        List<BoardVo> voList = boardService.selectList(pvo);
        HashMap<String, Object> map = new HashMap<>();
        map.put("pvo",pvo);
        map.put("voList",voList);
        return ResponseEntity.ok(map);

    }
    @GetMapping("/{no}")
    public ResponseEntity<Map<String, Object>> selectOne(@PathVariable String no,HttpSession session){
        BoardVo vo = boardService.selectOne(no);
        Map<String,Object> map = new HashMap<>();
        map.put("vo",vo);

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo!=null){
            String memberNo = loginMemberVo.getNo();
            boolean likeStatus = boardService.getLikeStatus(memberNo, no) == 1;
            map.put("likeStatus",likeStatus);
        }

        int likeCount = boardService.selectLikeCount(no);
        map.put("likeCount",likeCount);
        return ResponseEntity.ok(map);

    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateByNo(@RequestBody BoardVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        vo.setWriterNo(loginMemberVo.getNo());
        int result = boardService.updateByNo(vo);
        if (result!=1){
            String errMsg = "[B-410]update err...";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return ResponseEntity.ok(map);
    }
    @DeleteMapping
    public ResponseEntity<Map<String, Object>> deleteByNo(@RequestBody BoardVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        vo.setWriterNo(loginMemberVo.getNo());
        int result = boardService.deleteByNo(vo);
        if (result!=1){
            String errMsg = "[B-510]delete err ...";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        return ResponseEntity.ok(map);
    }

    @PostMapping("like/{boardNo}")
    public ResponseEntity<Map<String, Object>> like(HttpSession session, @PathVariable String boardNo){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String memberNo = loginMemberVo.getNo();
        Map<String,Object> map = new HashMap<>();
        map.put("boardNo", boardNo);
        map.put("memberNo", memberNo);
        boolean likeStatus = boardService.like(map);
        map.put("likeStatus",likeStatus);
        return ResponseEntity.ok(map);
    }







}
