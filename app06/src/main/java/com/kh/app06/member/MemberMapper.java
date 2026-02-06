package com.kh.app06.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {


    @Insert("""
    INSERT INTO MEMBER
    (
     ID
     , PW
     , NICK
    )
    VALUES 
        (
         #{id}
         , #{pw}
         , #{nick}
        )
    """)
    int join(MemberVo vo);

    @Select("""
    SELECT *
    FROM MEMBER
    WHERE ID = #{id}
    AND PW = #{pw}
    AND QUIT_YN = 'N'
    """)
    MemberVo login(MemberVo vo);

    @Update("""
    UPDATE MEMBER
        SET NICK = #{nick}
        , UPDATED_AT = SYSDATE
    WHERE NO = #{no}
    AND QUIT_YN = 'N'
    """)
    int editNick(MemberVo vo);

    @Update("""
    UPDATE MEMBER
        SET QUIT_YN = 'Y'
        , UPDATED_AT = SYSDATE
    WHERE NO = #{no}
    AND QUIT_YN = 'N'
    """)
    int quit(String no);
}
