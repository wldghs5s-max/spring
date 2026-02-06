package com.kh.app02.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    public int write(BoardVo vo) {
       int result = mapper.write(vo);

       if(result!=1){
           throw new IllegalStateException("게시글 작성 오류...");
       }
       return result;
    }

    public List<BoardVo> selectList() {

        return mapper.selectList();
    }

    public BoardVo selectByNo(String no) {
        BoardVo x = mapper.selectByNo(no);
        return x;
    }

    public int delete(String no) {
        int result = mapper.delete(no);

        if(result!=1){
            throw new IllegalStateException();
        }

        return result;
    }
}
