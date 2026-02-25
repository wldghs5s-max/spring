package com.kh.app11.book;

import com.kh.app11.aop.TimerAnno;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    @TimerAnno
    public int insert(BookVo vo) {
        log.info("서비스 메서드 호출됨~~");
        return bookMapper.insert(vo);
    }
}
