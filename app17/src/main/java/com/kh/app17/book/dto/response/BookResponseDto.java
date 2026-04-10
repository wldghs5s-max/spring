package com.kh.app17.book.dto.response;

import com.kh.app17.book.entity.BookEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
public class BookResponseDto {
    private Long id;
    private String title;
    private Integer price;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String delYn;

    public static BookResponseDto from(BookEntity entity){
        BookResponseDto dto = new BookResponseDto();
        dto.id= entity.getId();
        dto.title = entity.getTitle();
        dto.price = entity.getPrice();
        dto.createdAt = entity.getCretedAt();
        dto.modifiedAt = entity.getModifiedAt();
        dto.delYn = entity.getDelYn();
        return dto;
    }
}
