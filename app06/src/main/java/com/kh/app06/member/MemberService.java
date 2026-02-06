package com.kh.app06.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberMapper memberMapper;

    public int join(MemberVo vo) {
        return memberMapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return memberMapper.login(vo);
    }

    public int editNick(MemberVo vo) {
        return memberMapper.editNick(vo);
    }

    public int quit(String no) {
        return memberMapper.quit(no);
    }
}
