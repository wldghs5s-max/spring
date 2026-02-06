package com.kh.app03.book;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {


    @Insert("""
        INSERT INTO BOOK
        (
         TITLE
         , PRICE
        )VALUES 
             (
              #{title}
              , #{price}
             )
    """)
    int insert(BookVo vo);

    @Update("""
    UPDATE BOOK
        SET PRICE = #{price}
    WHERE NO = #{no}
    """)
    int edit(Map<String, String> map);

    @Select("""
    SELECT * FROM BOOK
    ORDER BY NO DESC
    """)
    List<BookVo> selectList();

    @Select("""
    SELECT * FROM BOOK
    WHERE NO = ${no}
    """)
    BookVo selectByNo(String no);

    @Delete("""
    DELETE BOOK
    WHERE NO = #{no}
    """)
    int delete(String no);
}
