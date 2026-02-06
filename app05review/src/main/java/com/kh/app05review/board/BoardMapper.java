package com.kh.app05review.board;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
    INSERT INTO BOARD
    (
     TITLE
     , CONTENT
     , WRITER_NO
    )
    VALUES 
        (
         #{title}
        , #{content}
        , #{writerNo}
         )
    """)
    int write(BoardVo vo);

    @Select("""
        SELECT *
        FROM BOARD
        WHERE DEL_YN = 'N'
        ORDER BY DESC
    """)
    List<BoardVo> selectList();
}
