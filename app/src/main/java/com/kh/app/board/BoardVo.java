package com.kh.app.board;

import lombok.Data;

@Data
public class BoardVo {
    private String no;
    private String title;
    private String content;
    private String writerNo;
    private String writerNick;
    private String hit;
    private String createdAt;
    private String updatedAt;
    private String delYn;
}
