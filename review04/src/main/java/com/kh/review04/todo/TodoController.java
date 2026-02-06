package com.kh.review04.todo;

import org.apache.ibatis.annotations.Delete;
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

    @PostMapping
    public int insert(TodoVo vo) throws Exception {
        return todoService.insert(vo);
    }

    @GetMapping
    public List<TodoVo> selectList(){
        return todoService.selectList();
    }

    @PutMapping
    public int update(String no){
        return todoService.update(no);
    }

    @GetMapping("detail")
    public TodoVo selectByNo(String no){
        return todoService.selectByNo(no);
    }
    @DeleteMapping
    public int delete(String no){
        return todoService.delete(no);
    }
}
