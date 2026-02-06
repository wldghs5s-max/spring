package com.kh.app04.todo;

import lombok.Data;

@Data
public class TodoVo {
    private String no;
    private String title;
    private String isDone;
    private String createdAt;
}
