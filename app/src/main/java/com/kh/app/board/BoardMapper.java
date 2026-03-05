package com.kh.app.board;

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
         , WRITER_NO
        ) VALUES 
              (
               #{title}
               ,#{content}
               ,#{writerNo}
              )
    """)
    int insert(BoardVo vo);

    @Select("""
        SELECT
            B.NO
            ,B.TITLE
            ,B.CONTENT
            ,B.WRITER_NO
            ,M.NICK         AS WRITER_NICK
            ,B.HIT
            ,B.CREATED_AT
            ,B.UPDATED_AT
        FROM BOARD B
        JOIN MEMBER M ON (B.WRITER_NO = M.NO)
        WHERE B.DEL_YN = 'N'
        ORDER BY B.NO DESC
    """)
    List<BoardVo> selectList();

    @Update("""
        UPDATE BOARD
        SET
            HIT = HIT+1
        WHERE NO = #{no}
        AND DEL_YN = 'N'
    """)
    int increaseHit(String no);

    @Select("""
        SELECT
            B.NO
            ,B.TITLE
            ,B.CONTENT
            ,B.WRITER_NO
            ,M.NICK         AS WRITER_NICK
            ,B.HIT
            ,B.CREATED_AT
            ,B.UPDATED_AT
        FROM BOARD B
        JOIN MEMBER M ON (B.WRITER_NO = M.NO)
        WHERE B.DEL_YN = 'N'
        AND B.NO = #{no}
    """)
    BoardVo selectOne(String no);

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
    int updateByNo(BoardVo vo);

    @Update("""
        UPDATE BOARD
        SET
            DEL_YN = 'Y'
            , UPDATED_AT = SYSDATE
        WHERE NO = #{no}
        AND WRITER_NO = #{writerNo}
    """)
    int deleteByNo(BoardVo vo);
}
