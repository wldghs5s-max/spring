package com.kh.app10.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("book")
public class BookRestController {

    private final BookService bookService;

    @PostMapping
    public int insert(BookVo vo){
        return bookService.insert(vo);

    }
}
