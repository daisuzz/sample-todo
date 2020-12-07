package com.daisuzz.samplethymeleaftodo.domain.todo

interface TodoRepository {

    fun getAllTodo(): List<Todo>

    fun getTodo(id: String): Todo

    fun createTodo(todo: Todo)

    fun updateTodo(todo: Todo)

    fun deleteTodo(id: String)
}
