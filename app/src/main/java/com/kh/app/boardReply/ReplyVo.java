package com.kh.app.boardReply;

import lombok.Data;

@Data
public class ReplyVo {

    private String no;
    private String content;
    private String boardNo;
    private String writerNo;
    private String createdAt;
    private String delYn;
    private String writerNick;
}
