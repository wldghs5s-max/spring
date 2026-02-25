package com.kh.app11.book;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("book")
public class BookRestController {

    private final BookService bookService;

    @PostMapping
    public int insert(BookVo vo){
        return bookService.insert(vo);
    }

}
