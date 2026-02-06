package com.kh.app03.member;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;


    public int insert(MemberVo vo) {
        return memberMapper.insert(vo);
    }

    public List<MemberVo> selectList() {
        return memberMapper.selectList();
    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }
}
