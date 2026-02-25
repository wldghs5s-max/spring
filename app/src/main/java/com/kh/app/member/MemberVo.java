package com.kh.app.member;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String id;
    private String pw;
    private String nick;
    private String hobby;
    private String profileChangeName;
    private String profileOriginName;
    private String createdAt;
    private String updatedAt;
    private String quitYn;
}
