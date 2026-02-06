package com.kh.app05member.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public int join(MemberVo vo) {
        return memberMapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }

    public int edit(MemberVo vo) {
        return memberMapper.edit(vo);
    }

    public int delete(String no) {
        return memberMapper.delete(no);
    }
}
