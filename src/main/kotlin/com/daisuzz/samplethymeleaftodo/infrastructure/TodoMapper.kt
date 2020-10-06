package com.daisuzz.samplethymeleaftodo.infrastructure

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TodoMapper {

    @Select("select * from todo")
    fun findAll(): List<TodoEntity>

    @Insert("insert into todo (id, title, detail, isDone) values (#{id}, #{title}, #{detail}, #{isDone})")
    fun create(todo: TodoEntity)

    @Delete("delete from todo where #{id}")
    fun delete(id: String)
}
