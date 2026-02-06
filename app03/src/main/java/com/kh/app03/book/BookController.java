package com.kh.app03.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("insert")
    @ResponseBody
    public int insert(BookVo vo){
        int result = bookService.insert(vo);
        if(result!=1){
            throw new IllegalStateException();
        }
        return result;
    }

    @GetMapping("edit")
    @ResponseBody
    public int edit(String no, String price){
        Map<String,String> map = new HashMap<>();
        map.put("no",no);
        map.put("price",price);
        int result = bookService.edit(map);
        return result;
    }

    @GetMapping("delete")
    @ResponseBody
    public int delete(String no){
        return bookService.delete(no);
    }

    @GetMapping("list")
    @ResponseBody
    public List<BookVo> selectList(){
        return bookService.selectList();
    }

    @GetMapping("detail")
    @ResponseBody
    public BookVo selectByNo(String no){
        return bookService.selectByNo(no);
    }

}
