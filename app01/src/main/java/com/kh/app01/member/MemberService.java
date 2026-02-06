package com.kh.app01.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    public int join(MemberVo vo) {

        return mapper.join(vo);
    }
}



























