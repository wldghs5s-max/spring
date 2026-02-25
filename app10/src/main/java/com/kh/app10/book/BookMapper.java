package com.kh.app10.book;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {



    @Insert("""
        INSERT INTO BOOK
        (
         TITLE,
         PRICE
        )
        VALUES 
            (
             #{title}
             , #{price}
            )
        """)
    int insert(BookVo vo);
}
