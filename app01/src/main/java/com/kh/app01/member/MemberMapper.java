package com.kh.app01.member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    @Insert("""
              INSERT INTO MEMBER
              (
                 ID
                 ,PW
                 ,NICK
              )
              VALUES
              (
                 #{id}
                 , #{pw}
                 , #{nick}
              )
""")
    int join(MemberVo vo);

}
