package com.kh.app18.book.service;

import com.kh.app18.book.dto.request.BookRequestDto;
import com.kh.app18.book.dto.response.BookResponseDto;
import com.kh.app18.book.entity.BookEntity;
import com.kh.app18.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookResponseDto save(BookRequestDto requestDto) {
        BookEntity entity = requestDto.toEntity();
        bookRepository.save(entity);
        return BookResponseDto.from(entity);
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto::from)
                .toList();
    }

    public BookResponseDto findById(Long id) {
        try {
            BookEntity entity = bookRepository.findById(id);
            return BookResponseDto.from(entity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "데이터 없음");
        }
    }
    @Transactional
    public void deleteById(Long id) {
        try {
            BookEntity entity = bookRepository.findById(id);
            entity.delete();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "이미 삭제됐거나 없는 데이터");
        }
    }
    @Transactional
    public BookResponseDto update(Long id, BookRequestDto requestDto) {
        BookEntity entity = bookRepository.findById(id);
        entity.change(requestDto.getTitle(), requestDto.getPrice());
        return BookResponseDto.from(entity);
    }
}
