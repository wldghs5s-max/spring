package com.kh.app02.board;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
    INSERT INTO BOARD
    (
     TITLE
     , CONTENT
    )
    VALUES 
    (
     #{title}
     , #{content}
    )
    """)
    int write(BoardVo vo);

    @Select("""
    SELECT *
    FROM BOARD
    WHERE DEL_YN = 'N'
    ORDER BY NO DESC
    """)
    List<BoardVo> selectList();

    @Select("""
    SELECT *
    FROM BOARD
    WHERE NO = #{no}
    AND DEL_YN = 'N'
    """)
    BoardVo selectByNo(String no);

    @Update("""
        UPDATE BOARD
            SET DEL_YN = 'Y'
        WHERE NO = #{no}
     """)
    int delete(String no);
}
