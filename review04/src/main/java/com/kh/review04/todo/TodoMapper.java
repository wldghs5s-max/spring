package com.kh.review04.todo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TodoMapper {

    @Insert("""
    INSERT INTO TODO
    (TITLE) VALUES (#{title})
    """)
    int insert(TodoVo vo);

    @Select("""
    SELECT * FROM TODO
    ORDER BY NO DESC
    """)
    List<TodoVo> selectList();

    @Update("""
    UPDATE TODO
        SET IS_DONE = 'Y'
    WHERE NO = #{no}
    """)
    int update(String no);

    @Select("""
    SELECT *
    FROM TODO
    WHERE NO = #{no}
    """)
    TodoVo selectByNo(String no);

    @Delete("""
    DELETE TODO
    WHERE NO = #{no}
    """)
    int delete(String no);
}
