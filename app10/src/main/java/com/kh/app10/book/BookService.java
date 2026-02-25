package com.kh.app10.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookMapper bookMapper;

    //트랜잭셔널 이체 예시
    public void order(){
        //입금
//        account.plus();
//      //출금
//        account.minus();
        //둘중 하나라도 실패하면 이전 결과 롤백처리 해야함. 트랜잭셔널 애너테이션 없으면 입금만되고 출금안될수도있음

    }
    @Transactional
    public int insert(BookVo vo) {
        int result = bookMapper.insert(vo);
        vo.setTitle(vo.getTitle() +" 감독판");

        //기존 가격에 할인율 붙인것 int화 이후 String 재변환 하기
        int price = Integer.parseInt(vo.getPrice());
        double discountPrice_ = price*0.9;
        int discountPrice = (int)discountPrice_;
        String str = discountPrice+"";
        vo.setPrice(str);

        int result2 = bookMapper.insert(vo);
        log.info("result : " + result);
        if(vo != null && vo.getPrice() != null && Integer.parseInt(vo.getPrice()) < 100){
            throw new IllegalStateException();
        }
        return result;
    }

}
