package com.kh.app.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class BoardService {
    private final BoardMapper boardMapper;

    @Transactional
    public int insert(BoardVo vo) {
        checkValid(vo);
        return boardMapper.insert(vo);
    }

    private void checkValid(BoardVo vo) {

    }

    public List<BoardVo> selectList() {
        return boardMapper.selectList();
    }

    @Transactional
    public BoardVo selectOne(String no) {
        int result = boardMapper.increaseHit(no);
        if(result!=1){
            String errMsg = "[B-321] increase hit fail...";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return boardMapper.selectOne(no);
    }
    @Transactional
    public int updateByNo(BoardVo vo) {
        return boardMapper.updateByNo(vo);
    }

    public int deleteByNo(BoardVo vo) {
        return boardMapper.deleteByNo(vo);
    }
}
