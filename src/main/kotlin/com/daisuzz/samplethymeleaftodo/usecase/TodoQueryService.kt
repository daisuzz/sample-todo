package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.Todo
import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoQueryService(private val todoRepository: TodoRepository) {

    fun getAllTodo(): List<Todo> {
        return todoRepository.getAllTodo()
    }
}