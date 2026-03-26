package com.kh.app.board;

import com.kh.app.util.PageVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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
        OFFSET #{offset} ROWS
        FETCH NEXT #{boardLimit} ROWS ONLY
    """)
    List<BoardVo> selectList(PageVo pvo);

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

    @Select("""
        SELECT COUNT(NO)
        FROM BOARD        
        WHERE DEL_YN = 'N'
    """)
    int selectCount();

    @Insert("""
        INSERT INTO BOARD_LIKE
        (MEMBER_NO, BOARD_NO)
        VALUES
        (#{memberNo},#{boardNo})
    """)
    int insertlike(Map<String, Object> map);

    @Delete("""
        DELETE FROM BOARD_LIKE
        WHERE MEMBER_NO = #{memberNo}
        AND BOARD_NO = #{boardNo}
    """)
    int deletetlike(Map<String, Object> map);

    @Select("""
        SELECT COUNT(*)
        FROM BOARD_LIKE
        WHERE BOARD_NO = #{boardNo}
        AND MEMBER_NO = #{memberNo}
    """)
    int existlike(Map<String, Object> map);

    @Select("""
        SELECT COUNT(*)
        FROM BOARD_LIKE
        WHERE MEMBER_NO = #{memberNo}
        AND BOARD_NO = #{boardNo}
    """)
    int existlike2(@Param("memberNo") String memberNo,@Param("boardNo") String boardNo);


    @Select("""
        SELECT COUNT(*)
        FROM BOARD_LIKE
        WHERE BOARD_NO = #{boardNo}
    """)
    int selectLikeCount(String boardNo);






}
