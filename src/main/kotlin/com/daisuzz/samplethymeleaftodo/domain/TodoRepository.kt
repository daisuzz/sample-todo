package com.daisuzz.samplethymeleaftodo.domain

interface TodoRepository {

    fun getAllTodo(): List<Todo>

    fun createTodo(todo: Todo)

    fun deleteTodo(id: String)
}