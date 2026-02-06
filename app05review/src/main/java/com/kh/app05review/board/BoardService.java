package com.kh.app05review.board;

import com.kh.app05review.member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardVo vo) {
        return boardMapper.write(vo);
    }

    public List<BoardVo> selectList() {
        return boardMapper.selectList();
    }
}
