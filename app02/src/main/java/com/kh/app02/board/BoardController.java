package com.kh.app02.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("board/write")
    public String write(){
        return "board/write";
    }
    @PostMapping("board/write")
    public String write(BoardVo vo){
        int result = service.write(vo);

        if(result!=1){
            return "redirect:/error";
        }
        //view
        return "redirect:/board/list";
    }

    @RequestMapping("board/list")
    public String selectList(Model model){
        List<BoardVo> voList = service.selectList();
        model.addAttribute("voList",voList);
        return "board/list";
    }
    //게시글 상세 조회
    @RequestMapping("board/detail")
    public String selectByNo(Model model,String no){
        BoardVo vo = service.selectByNo(no);
        if(vo==null){
            throw new IllegalStateException("상세조회 에러");
        }
        model.addAttribute("vo",vo);
        return "board/detail";
    }

    @GetMapping("board/delete")
    public String delete(String no){
        try {
            int result = service.delete(no);
            if(result!=1){
                throw new IllegalStateException();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "redirect:/board/list";
    }



















}
