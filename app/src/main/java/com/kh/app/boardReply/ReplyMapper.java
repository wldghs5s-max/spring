package com.kh.app.boardReply;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Insert("""
        INSERT INTO BOARD_REPLY
        (
            CONTENT
            ,BOARD_NO
            ,WRITER_NO
        )
        VALUES
        (
        #{content}
        ,#{boardNo}
        ,#{writerNo}
        )
        
    """)
    int insert(ReplyVo vo);

    @Select("""
            SELECT
            R.NO
            ,R.CONTENT
            ,R.BOARD_NO
            ,R.WRITER_NO
            ,R.CREATED_AT
            ,M.NICK AS WRITER_NICK
            FROM BOARD_REPLY R
            JOIN MEMBER M ON (M.NO = R.WRITER_NO)
            WHERE R.DEL_YN = 'N'
            AND R.BOARD_NO = #{boardNo}
            ORDER BY R.NO DESC
            """)
    List<ReplyVo> selectList(String boardNo);

    @Update("""
            UPDATE BOARD_REPLY
                SET DEL_YN = 'Y'
            WHERE NO = #{no}
            AND WRITER_NO = #{writerNo}
            """)
    int del(ReplyVo vo);
}
