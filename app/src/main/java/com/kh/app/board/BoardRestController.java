package com.kh.app.board;

import com.kh.app.member.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<HashMap<String, Object>> selectList(){
        List<BoardVo> voList = boardService.selectList();
        HashMap<String, Object> map = new HashMap<>();
        map.put("voList",voList);
        return ResponseEntity.ok(map);

    }
    @GetMapping("/{no}")
    public ResponseEntity<Map<String, Object>> selectOne(@PathVariable String no){
        BoardVo vo = boardService.selectOne(no);
        Map<String,Object> map = new HashMap<>();
        map.put("vo",vo);
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

}
