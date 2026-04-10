package com.kh.app18.book.dto.request;

import com.kh.app18.book.entity.BookEntity;
import lombok.Getter;
import lombok.ToString;

import java.awt.print.Book;

@Getter
@ToString
public class BookRequestDto {
    private String title;
    private Integer price;

    public BookEntity toEntity(){
        return BookEntity
                .builder()
                .title(title)
                .price(price)
                .build();
    }
}
