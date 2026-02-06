package com.kh.app06.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardMapper boardMapper;

    public int insert(BoardVo vo) {
        return boardMapper.insert(vo);
    }

    public List<BoardVo> selectList() {
        return boardMapper.selectList();
    }

    public BoardVo selectByNo(String no) {
        int result = boardMapper.increaseHit(no);
        if(result !=1){
            throw new IllegalStateException();
        }
        return boardMapper.selectByNo(no);
    }

    public int update(BoardVo vo) {
        return boardMapper.update(vo);
    }

    public int delete(BoardVo boardVo) {
        return boardMapper.delete(boardVo);
    }
}
