package com.kh.app17.book.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOOK")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookEntity {
    @Id
    @SequenceGenerator(sequenceName = "SEQ_BOOK" ,name = "book_seq_gen", allocationSize = 1)
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer price;

    @Builder.Default
    private LocalDateTime cretedAt = LocalDateTime.now();
    private LocalDateTime modifiedAt;
    @Column(length = 1, nullable = false)
    @Builder.Default
    private String delYn ="N";

    //삭제하기
    public void delete(){
        this.delYn = "Y";
        this.modifiedAt = LocalDateTime.now();
    }
    //수정하기
    public void change(String title, Integer price){
        this.title = title;
        this.price = price;
        this.modifiedAt = LocalDateTime.now();
    }

}
