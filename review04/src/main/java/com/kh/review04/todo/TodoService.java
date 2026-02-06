package com.kh.review04.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;

    public int insert(TodoVo vo) throws Exception {
        int result = todoMapper.insert(vo);
        if(result!=1){
            throw new Exception();
        }
        return result;
    }

    public List<TodoVo> selectList() {
        return todoMapper.selectList();
    }

    public int update(String no) {
        return todoMapper.update(no);
    }

    public TodoVo selectByNo(String no) {
        return todoMapper.selectByNo(no);
    }

    public int delete(String no) {
        return todoMapper.delete(no);
    }
}
