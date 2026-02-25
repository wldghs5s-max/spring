package com.kh.app.member;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO MEMBER
        (
         ID
         ,PW
         ,NICK
         ,HOBBY
         ,PROFILE_CHANGE_NAME
         ,PROFILE_ORIGIN_NAME
        )
        VALUES 
            (
             #{id}
             ,#{pw}
             ,#{nick}
             ,#{hobby}
             ,#{profileChangeName}
             ,#{profileOriginName}
            )
    """)
    int join(MemberVo vo);

    @Select("""
        SELECT
            NO
            , NAME
        FROM HOBBY
    """)
    List<HobbyVo> selectHobbyList();

    @Select("""
        SELECT 
            NO
            ,ID
            ,PW
            ,NICK
            ,HOBBY
            ,PROFILE_CHANGE_NAME
            ,PROFILE_ORIGIN_NAME
            ,CREATED_AT
            ,UPDATED_AT
        FROM MEMBER
        WHERE ID = #{id}
        AND QUIT_YN = 'N'
    """)
    MemberVo selectById(String id);

    @Update("""
        UPDATE MEMBER
        SET 
            QUIT_YN = 'Y'
            , UPDATED_AT = SYSDATE
        WHERE NO = #{no}
    """)
    int quit(String no);
}
