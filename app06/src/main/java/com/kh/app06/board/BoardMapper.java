package com.kh.app06.board;

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
     ,CONTENT
     ,WRITER_NO
    )
    VALUES 
        (
         #{title}
         , #{content}
         , #{writerNo}
        )
    
    """)
    int insert(BoardVo vo);

    @Select("""
        SELECT B.* , M.NICK WRITER_NICK
        FROM BOARD B 
        JOIN MEMBER M
        ON (M.NO = B.WRITER_NO)
        WHERE B.DEL_YN = 'N'
        ORDER BY B.NO DESC
    """)
    List<BoardVo> selectList();

    @Select("""
        SELECT B.* , M.NICK WRITER_NICK
        FROM BOARD B 
        JOIN MEMBER M
        ON (M.NO = B.WRITER_NO)
        WHERE B.DEL_YN = 'N'
        AND B.NO = #{no}
        ORDER BY B.NO DESC  
    """)
    BoardVo selectByNo(String no);

    @Update("""
        UPDATE BOARD
            SET 
                TITLE = #{title}
                , CONTENT = #{content}
                , UPDATED_AT = SYSDATE
        WHERE NO = #{no}
        AND WRITER_NO = #{writerNo}
        AND DEL_YN = 'N'
    """)
    int update(BoardVo vo);

    @Update("""
        UPDATE BOARD
            SET
                DEL_YN = 'Y'
        WHERE NO = #{no}
        AND WRITER_NO = #{writerNo}
        AND DEL_YN = 'N'
    """)
    int delete(BoardVo boardVo);

    @Update("""
        UPDATE BOARD
            SET 
                HIT = HIT+1
        WHERE NO = #{no}
        AND DEL_YN = 'N'
    """)
    int increaseHit(String no);

}




















