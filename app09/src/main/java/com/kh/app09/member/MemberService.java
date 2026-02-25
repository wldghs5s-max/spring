package com.kh.app09.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public int join(MemberVo vo) {
        String encodedPw = bCryptPasswordEncoder.encode(vo.getPw());
        vo.setPw(encodedPw);
        return memberMapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        MemberVo dbVo = memberMapper.login(vo);
        boolean isMatch = bCryptPasswordEncoder.matches(vo.getPw(),dbVo.getPw());
        if (!isMatch){
            throw new IllegalArgumentException("check pw plz..");
        }
            return dbVo;
    }
}







