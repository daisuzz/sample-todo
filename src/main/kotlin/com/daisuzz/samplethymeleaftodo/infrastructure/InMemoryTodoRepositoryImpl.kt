package com.daisuzz.samplethymeleaftodo.infrastructure

import com.daisuzz.samplethymeleaftodo.domain.Todo
import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryTodoRepositoryImpl : TodoRepository {

    private val cache = mutableListOf<Todo>()

    override fun getAllTodo(): List<Todo> {
        return cache.toList()
    }

    override fun createTodo(todo: Todo) {
        cache.add(todo)
    }

    override fun deleteTodo(id: String) {
        cache.removeIf { it.id == id }
    }
}