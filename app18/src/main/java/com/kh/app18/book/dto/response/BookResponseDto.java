package com.kh.app18.book.dto.response;

import com.kh.app18.book.entity.BookEntity;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public static BookResponseDto from(BookEntity entity) {
        return BookResponseDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .title(entity.getTitle())
                .createdAt(entity.getCreatedAt())
                .modifiedAt(entity.getModifiedAt())
                .build();


    }
}
