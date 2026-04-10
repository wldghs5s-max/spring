package com.kh.app18.book.entity;

import com.kh.app18.book.dto.request.BookRequestDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookEntity {
    @Id
    @SequenceGenerator(name = "book_seq_gen", sequenceName = "SEQ_BOOK",allocationSize = 1)
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false , length = 80)
    private String title;
    @Column(nullable = false)
    private Integer price;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime modifiedAt;
    @Builder.Default
    @Column(length = 1,nullable = false)
    private String delYn = "N";
    public void delete(){
        delYn = "Y";
        modifiedAt = LocalDateTime.now();
    }
    public void change(String title, Integer price){
        this.title = title;
        this.price = price;
        modifiedAt = LocalDateTime.now();
    }

}
