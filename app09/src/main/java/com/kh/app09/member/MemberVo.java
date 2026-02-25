package com.kh.app09.member;

import lombok.Data;

@Data
public class MemberVo {

    private String no;
    private String id;
    private String pw;
    private String nick;
    private String profile;
    private String originName;
    private String createdAt;
    private String updatedAt;
    private String quitYn;

}
