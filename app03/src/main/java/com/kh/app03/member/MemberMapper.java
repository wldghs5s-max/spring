package com.kh.app03.member;

import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    int insert(MemberVo vo);

    @Select("""
    SELECT * FROM MEMBER
    WHERE QUIT_YN = 'N'
    ORDER BY NO DESC
    """)
    List<MemberVo> selectList();

    @Select("""
        SELECT * FROM MEMBER
        WHERE ID = #{id}
        AND PW = #{pw}
        AND QUIT_YN = 'N'
    """)
    MemberVo login(MemberVo vo);
}
