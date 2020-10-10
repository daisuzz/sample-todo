package com.daisuzz.samplethymeleaftodo.infrastructure

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper()
interface TodoMapper {

    @Select("select * from todo")
    fun findAll(): List<TodoEntity>

    @Select("select * from todo where id = #{id}")
    fun find(id: String): TodoEntity

    @Insert("insert into todo (id, title, detail, isDone) values (#{id}, #{title}, #{detail}, #{isDone})")
    fun create(todo: TodoEntity)

    @Insert("update todo set title = #{title}, detail = #{detail}, isDone = #{isDone} where id = #{id}")
    fun update(todo: TodoEntity)

    @Delete("delete from todo where id = #{id}")
    fun delete(id: String)
}
