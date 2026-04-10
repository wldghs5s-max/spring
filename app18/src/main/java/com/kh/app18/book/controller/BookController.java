package com.kh.app18.book.controller;

import com.kh.app18.book.dto.request.BookRequestDto;
import com.kh.app18.book.dto.response.BookResponseDto;
import com.kh.app18.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> save(@RequestBody BookRequestDto requestDto) {
        BookResponseDto responseDto = bookService.save(requestDto);
        return ResponseEntity.status(200).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAll() {
        List<BookResponseDto> voList = bookService.findAll();
        return ResponseEntity.ok(voList);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponseDto> findById(@PathVariable Long id) {
        BookResponseDto dto = bookService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<BookResponseDto> updateTitleAndPriceById(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        BookResponseDto update = bookService.update(id, requestDto);
        return ResponseEntity.ok(update);
    }
}
