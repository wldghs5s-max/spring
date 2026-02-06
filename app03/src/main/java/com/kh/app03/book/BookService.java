package com.kh.app03.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public int insert(BookVo vo) {

        return bookMapper.insert(vo);
    }

    public int edit(Map<String, String> map) {
        return bookMapper.edit(map);
    }

    public List<BookVo> selectList() {
        return bookMapper.selectList();

    }

    public BookVo selectByNo(String no) {
        return bookMapper.selectByNo(no);
    }

    public int delete(String no) {
        return bookMapper.delete(no);
    }
}
