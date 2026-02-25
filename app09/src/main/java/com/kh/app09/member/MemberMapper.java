package com.kh.app09.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Insert("""
    INSERT INTO MEMBER
        (
         ID
         ,PW
         ,NICK
        )
        VALUES (
                #{id}
                ,#{pw}
                ,#{nick}
        )
    """)
    int join(MemberVo vo);


    @Select("""
    SELECT *
    FROM MEMBER
    WHERE ID = #{id}
    AND QUIT_YN = 'N'
    """)
    MemberVo login(MemberVo vo);
}
