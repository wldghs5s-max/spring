package com.kh.app.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("join")
    public ResponseEntity<HashMap<String, String>> join(
            MemberVo vo
            , @RequestParam(required = false) String[] hobbys
            , @RequestParam(required = false) MultipartFile profile
    ) throws IOException {
        System.out.println("vo = " + vo);
        System.out.println(profile);

        //취미 배열 -> 취미 문자열
        String str = String.join(",", hobbys);
        vo.setHobby(str);

        int result = memberService.join(vo, profile);

        HashMap<String, String> map = new HashMap<>();
        map.put("x" , String.valueOf(result));
        return ResponseEntity.ok(map);
    }//method

    @GetMapping("hobby")
    public ResponseEntity<List<HobbyVo>> selectHobbyList(){
        List<HobbyVo> voList = memberService.selectHobbyList();
        return ResponseEntity.ok(voList);
    }
    @GetMapping("hobby/user")
    public ResponseEntity<HashMap<String, String>> selectUserHobbyList(HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        HashMap<String, String> map = new HashMap<>();
        map.put("hobby",loginMemberVo.getHobby());

        return ResponseEntity
                .ok()
                .body(map);
    }

    @PostMapping("login")
    public ResponseEntity.BodyBuilder login(@RequestBody MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = memberService.login(vo);
        if(loginMemberVo==null){
            new IllegalArgumentException("[MEM-201] login err...");
        }
        session.setAttribute("loginMemberVo", loginMemberVo);
        return ResponseEntity.ok();
    }

    @GetMapping("logout")
    public ResponseEntity<Object> logout(HttpSession session){
        session.invalidate();
//      session.removeAttribute("loginMemberVo");
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header(HttpHeaders.LOCATION,"/home")
                .build();
    }
    @DeleteMapping("quit")
    public ResponseEntity.BodyBuilder quit(HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        int result = memberService.quit(no);
        if(result!=1){
            throw new IllegalStateException("[M-500]");
        }
        return ResponseEntity.ok();
    }
}