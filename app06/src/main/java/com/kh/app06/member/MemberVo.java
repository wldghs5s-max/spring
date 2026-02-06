package com.kh.app06.member;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String id;
    private String pw;
    private String nick;
    private String createdAt;
    private String updatedAt;
    private String quitYn;

}
