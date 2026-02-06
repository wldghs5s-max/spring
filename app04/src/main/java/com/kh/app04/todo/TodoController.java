package com.kh.app04.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("todo")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService todoService;

    //insert
    @PostMapping
    public int insert(TodoVo vo) throws Exception {
        int result = todoService.insert(vo);
        if (result!=1){
            throw new Exception();
        }
        return result;
    }

    //selectList
    @GetMapping
    public List<TodoVo> selectList(){
        List<TodoVo> voList = todoService.selectList();
        return voList;
    }

    //selectOne
    @GetMapping("/detail")
    public TodoVo selectOneByNo(String no){
        TodoVo vo = todoService.selectOneByNo(no);
        return vo;
    }

    //update(완료체크)
    @PutMapping
    public int update(TodoVo vo){
        int result = todoService.update(vo);
        return result;
    }

    //delete
    @DeleteMapping
    public int delete(String no){
        int result = todoService.delete(no);
        return result;
    }




}//class












