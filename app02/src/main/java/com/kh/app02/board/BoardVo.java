package com.kh.app02.board;

import lombok.Data;

@Data
public class BoardVo {

    private String no;
    private String title;
    private String content;
    private String hit;
    private String createdAt;
    private String updatedAt;
    private String delYn;

}
