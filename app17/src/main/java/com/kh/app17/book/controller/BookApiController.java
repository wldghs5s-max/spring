package com.kh.app17.book.controller;

import com.kh.app17.book.dto.request.BookInsertRequestDto;
import com.kh.app17.book.dto.response.BookResponseDto;
import com.kh.app17.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/book")
@CrossOrigin
public class BookApiController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> save(@RequestBody BookInsertRequestDto dto){
        BookResponseDto respDto = bookService.save(dto);
        return ResponseEntity
                .status(200)
                .body(respDto);
    }

    @GetMapping
    public List<BookResponseDto> findAll(){
        return bookService.findAll();
    }


    @GetMapping("{id}")
    public BookResponseDto findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.status(204).build();
    }
    @PutMapping("{id}")
    public BookResponseDto update(@PathVariable Long id, @RequestBody BookInsertRequestDto requestDto){
        return bookService.update(id, requestDto);
    }






}
