package com.kh.app04.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;


    public int insert(TodoVo vo) {
        return todoMapper.insert(vo);
    }

    public List<TodoVo> selectList() {
        return todoMapper.selectList();
    }

    public TodoVo selectOneByNo(String no) {
        return todoMapper.selectOneByNo(no);
    }

    public int update(TodoVo vo) {
        return todoMapper.update(vo);
    }

    public int delete(String no) {
        return todoMapper.delete(no);
    }
}//class










