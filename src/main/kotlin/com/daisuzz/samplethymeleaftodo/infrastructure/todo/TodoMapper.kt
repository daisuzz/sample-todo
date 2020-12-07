package com.daisuzz.samplethymeleaftodo.infrastructure.todo

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface TodoMapper {

    @Select("select * from t_todo")
    fun findAll(): List<TodoEntity>

    @Select("select * from t_todo where id = #{id}")
    fun find(id: String): TodoEntity

    @Insert("insert into t_todo (id, title, detail, isDone) values (#{id}, #{title}, #{detail}, #{isDone})")
    fun create(todo: TodoEntity)

    @Insert("update t_todo set title = #{title}, detail = #{detail}, isDone = #{isDone} where id = #{id}")
    fun update(todo: TodoEntity)

    @Delete("delete from t_todo where id = #{id}")
    fun delete(id: String)
}
