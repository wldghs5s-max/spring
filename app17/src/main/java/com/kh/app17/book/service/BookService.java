package com.kh.app17.book.service;

import com.kh.app17.book.dto.request.BookInsertRequestDto;
import com.kh.app17.book.dto.response.BookResponseDto;
import com.kh.app17.book.entity.BookEntity;
import com.kh.app17.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookResponseDto save(BookInsertRequestDto dto) {
        BookEntity entity = dto.toEntity();
        bookRepository.save(entity);

        return BookResponseDto.from(entity);
    }

    public List<BookResponseDto> findAll() {
        List<BookEntity> entityList = bookRepository.findAll();
//        ArrayList<BookInsertResponseDto> dtoList = new ArrayList<>();
//        for (BookEntity entity:entityList){
//            BookInsertResponseDto respDto = BookInsertResponseDto.from(entity);
//            dtoList.add(respDto);
//        }

//        List<BookInsertResponseDto> dtoList = entityList.stream().map((entity) -> BookInsertResponseDto.from(entity)).toList();
        return entityList.stream().map(BookResponseDto::from).toList();
    }

    public BookResponseDto findById(Long id) {
        BookEntity entity = bookRepository.findById(id);
        return BookResponseDto.from(entity);

    }
    @Transactional
    public void delete(Long id) {
        BookEntity entity = bookRepository.findById(id);
        if(entity.getDelYn()=="Y"){
            throw new IllegalStateException("이미 삭제된 도서입니다.");
        }
        entity.delete();
    }
    @Transactional
    public BookResponseDto update(Long id, BookInsertRequestDto requestDto) {
        BookEntity entity = bookRepository.findById(id);
        entity.change(requestDto.getTitle(),requestDto.getPrice());

        return BookResponseDto.from(entity);
    }
}
