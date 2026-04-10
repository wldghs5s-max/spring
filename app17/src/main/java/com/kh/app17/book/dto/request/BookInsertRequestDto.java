package com.kh.app17.book.dto.request;
import com.kh.app17.book.entity.BookEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BookInsertRequestDto {
    private String title;
    private Integer price;

    public BookEntity toEntity() {
        return BookEntity
                .builder()
                .title(title)
                .price(price)
                .build();
    }
}
